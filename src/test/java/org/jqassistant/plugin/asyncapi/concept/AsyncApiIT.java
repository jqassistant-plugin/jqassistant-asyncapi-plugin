package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.report.api.model.Column;
import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Concept;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ChannelDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.MessageDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.buschmais.jqassistant.core.report.api.model.Result.Status.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class AsyncApiIT extends AbstractPluginIT {

    @Test
    void resolveChannelsAndOperations() throws RuleException {
        File file = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        Result<Concept> result2 = applyConcept("asyncapi:Operations");
        assertThat(result2.getStatus()).isEqualTo(SUCCESS);
        Column<?> operations = result2.getRows().get(0).getColumns().get("Operations");
        assertThat(operations).isNotNull();
        assertThat(operations.getValue()).isEqualTo(1L);
        List<ChannelDescriptor> mappedChannel =
                query("MATCH (a:Channel)-[:MAPS_TO]->(:Channel), (:Operation)-[:SENDS_TO]->(:Operation) return count(a) as mappedChannel").getColumn("mappedChannel");
        assertThat(mappedChannel.size()).isEqualTo(1);
        List<ChannelDescriptor> sendingOperation =
                query("MATCH (:Channel)-[:MAPS_TO]->(:Channel), (:Operation)-[:SENDS_TO]->(o:Operation) return count(o) as operation").getColumn("operation");
        assertThat(sendingOperation.size()).isEqualTo(1);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        store.commitTransaction();
    }

    @Test
    void resolveReferences() throws RuleException {
        File file = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        Result<Concept> result = applyConcept("asyncapi:resolveReferences");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Column<?> nodes = result.getRows().get(0).getColumns().get("Node");
        assertThat(nodes).isNotNull();
        assertThat(nodes.getValue()).isEqualTo(7L);
        Column<?> sources = result.getRows().get(0).getColumns().get("Source");
        assertThat(sources).isNotNull();
        assertThat(sources.getValue()).isEqualTo(7L);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        List<ReferenceDescriptor> reference =
                query("MATCH (:Operation{name:'send_WaterlooOperation'})-[:ON_CHANNEL]->(a:Reference)-[:REFERENCES]->(:Reference)-[:REFERENCES]->(b:Channel), (a)-[:RESOLVES_TO]->(b) return a").getColumn("a");
        assertThat(reference.size()).isEqualTo(1);
        List<MessageDescriptor> allTargetMessage =
                query("MATCH (:Operation)-[:USING_MESSAGE]-(:Message)-[:RESOLVES_TO*0..1]->(target:Message) return target").getColumn("target");
        assertThat(allTargetMessage.size()).isEqualTo(2);
        store.commitTransaction();
    }
}
