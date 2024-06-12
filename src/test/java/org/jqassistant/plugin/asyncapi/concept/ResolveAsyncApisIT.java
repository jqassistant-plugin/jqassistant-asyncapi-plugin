package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.report.api.model.Column;
import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Concept;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.buschmais.jqassistant.core.report.api.model.Result.Status.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class ResolveAsyncApisIT extends AbstractPluginIT {

    @Test
    void resolveChannels() throws RuleException {
        File file = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        applyConcept("asyncapi:References");
        Result<Concept> result = applyConcept("asyncapi:Channels");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Column<?> channels = result.getRows().get(0).getColumns().get("Channels");
        assertThat(channels).isNotNull();
        assertThat(channels.getValue()).isEqualTo(2L);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        store.commitTransaction();
    }

    @Test
    void resolveOperations() throws RuleException {
        File file = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        applyConcept("asyncapi:References");
        applyConcept("asyncapi:Channels");
        Result<Concept> result = applyConcept("asyncapi:Operations");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Column<?> operations = result.getRows().get(0).getColumns().get("Operations");
        assertThat(operations).isNotNull();
        assertThat(operations.getValue()).isEqualTo(1L);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        store.commitTransaction();
    }

    @Test
    void resolveReferences() throws RuleException {
        File file = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        Result<Concept> result2 = applyConcept("asyncapi:References");
        assertThat(result2.getStatus()).isEqualTo(SUCCESS);
        Result<Concept> result = applyConcept("asyncapi:Channels");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Result<Concept> result3 = applyConcept("asyncapi:Operations");
        assertThat(result3.getStatus()).isEqualTo(SUCCESS);
        Result<Concept> result4 = applyConcept("asyncapi:ChannelReferences");
        assertThat(result4.getStatus()).isEqualTo(SUCCESS);
        Result<Concept> result5 = applyConcept("asyncapi:MessageReferences");
        assertThat(result5.getStatus()).isEqualTo(SUCCESS);
        Column<?> messages = result5.getRows().get(0).getColumns().get("Messages");
        assertThat(messages).isNotNull();
        assertThat(messages.getValue()).isEqualTo(3L);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        store.commitTransaction();
    }


    @Test
    void deleteReferenceableRelation() throws RuleException {
        File file = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(ResolveAsyncApisIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        Result<Concept> result = applyConcept("asyncapi:Referenceables");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Column<?> nodes = result.getRows().get(0).getColumns().get("Nodes");
        assertThat(nodes).isNotNull();
        assertThat(nodes.getValue()).isEqualTo(20L);
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        store.commitTransaction();
    }



}
