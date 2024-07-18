package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.report.api.model.Row;
import com.buschmais.jqassistant.core.rule.api.model.Concept;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import com.buschmais.xo.api.ResultIterator;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ChannelDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.MessageDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.OperationDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.buschmais.jqassistant.core.report.api.model.Result.Status.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class AsyncApiIT extends AbstractPluginIT {

    @BeforeEach
    void init() {
        File file = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
    }

    @Test
    void channelMapsToChannelInSeparateContracts() throws RuleException {
        applyConcept("jqassistant-plugin-asyncapi:ChannelMapsToChannel");
        store.beginTransaction();

        Query.Result<Query.Result.CompositeRowObject> result =
                store.executeQuery("MATCH (a:Contract:AsyncAPI)-[:DEFINES_CHANNEL]->(c1:Channel), (b:Contract:AsyncAPI)-[:DEFINES_CHANNEL]->(c2:Channel), (c1)-[:MAPS_TO]->(c2) RETURN c1.referenceableKey AS key1");

        ResultIterator<Query.Result.CompositeRowObject> iterator = result.iterator();
        String name = iterator.next().get("key1", String.class);
        String name2 = iterator.next().get("key1", String.class);
        assertThat(name).isEqualTo(name2);
        store.commitTransaction();

    }

    @Test
    void resolveReferences() throws RuleException {
        Result<Concept> result =  applyConcept("jqassistant-plugin-asyncapi:ReferenceResolvesToTarget");

        store.beginTransaction();
        assertThat(result.getRows().size()).isEqualTo(7);

        List<ChannelDescriptor> singleReferenceChannel =
                query("MATCH (a:Contract:AsyncAPI)-[:DEFINES_CHANNEL]->(c1:Reference:Channel)-[:REFERENCES]->(c2:Channel), (c1)-[:RESOLVES_TO]->(c2) WHERE NOT (c2)-[:REFERENCES]->(:AsyncAPI) RETURN count(c1) as Sources").getColumn("Sources");
        assertThat(singleReferenceChannel.size()).isEqualTo(1);

        List<ChannelDescriptor> multipleReferenceChannel =
                query("MATCH (a:Contract:AsyncAPI)-[:DEFINES_CHANNEL]->(c1:Reference:Channel)-[:REFERENCES*2..]->(c2:Channel), (c1)-[:RESOLVES_TO]->(c2) WHERE NOT (c2:Reference)  return count(c1) as Sources").getColumn("Sources");
        assertThat(multipleReferenceChannel.size()).isEqualTo(1);

        List<MessageDescriptor> multipleReferenceMessage =
                query("MATCH (a:Contract:AsyncAPI)-[:DEFINES_MESSAGE]->(c1:Reference:Message)-[:REFERENCES*2..]->(c2:Message), (c1)-[:RESOLVES_TO]->(c2) WHERE NOT (c2:Reference)  return count(c1) as Sources").getColumn("Sources");
        assertThat(multipleReferenceMessage.size()).isEqualTo(1);
        store.commitTransaction();
    }

    @Test
    void operationSendsToOperation() throws RuleException {
        Result<Concept> result = applyConcept("jqassistant-plugin-asyncapi:OperationSendsToOperation");

        store.beginTransaction();
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        assertThat(result.getRows().size()).isEqualTo(1);
        Row row = result.getRows().get(0);
        Object sendOperation = row.getColumns().get("SendOperation").getValue();
        assertThat(sendOperation).isInstanceOf(OperationDescriptor.class);
        assertThat(((OperationDescriptor) sendOperation).getPath()).isEqualTo("#/operations/send_WaterlooOperation");
        assertThat(((OperationDescriptor) sendOperation).getAction()).isEqualTo("send");
        Object receiveOperation = row.getColumns().get("ReceiveOperation").getValue();
        assertThat(receiveOperation).isInstanceOf(OperationDescriptor.class);
        assertThat(((OperationDescriptor) receiveOperation).getPath()).isEqualTo("#/operations/receive_WaterlooOperation");
        assertThat(((OperationDescriptor) receiveOperation).getAction()).isEqualTo("receive");

        TestResult testResult = query("MATCH (a:Contract:AsyncAPI)-[:DEFINES_OPERATION]-(o1:Operation {action: 'send'}), (b:Contract:AsyncAPI)-[:DEFINES_OPERATION]-(o2:Operation {action: 'receive'}), (o1)-[:SENDS_TO]->(o2) RETURN o1.referenceableKey as key1, o2.referenceableKey as key2");
        String name = testResult.getColumn("key1").get(0).toString();
        String name2 = testResult.getColumn("key2").get(0).toString();
        assertThat(name).isEqualTo("send_WaterlooOperation");
        assertThat(name2).isEqualTo("receive_WaterlooOperation");
        store.commitTransaction();

    }
}
