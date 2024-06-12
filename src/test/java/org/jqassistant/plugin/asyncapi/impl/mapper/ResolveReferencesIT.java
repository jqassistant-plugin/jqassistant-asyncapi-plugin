package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class ResolveReferencesIT extends AbstractPluginIT {

    @Test
    void resolveChannels() throws RuleException {
        File file = new File(getClassesDirectory(ResolveReferencesIT.class), "testAsyncApi/resolveChannelAddressTest.yml");
        File file2 = new File(getClassesDirectory(ResolveReferencesIT.class), "testAsyncApi/resolveChannelAddressTest2.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest.yml", AsyncApiScope.CONTRACT);
        ContractDescriptor contract2 = getScanner().scan(file2, "testAsyncApi/resolveChannelAddressTest2.yml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
        //simple attributes
        TestResult result = query("MATCH (contract:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation{name: 'receive_WaterlooOperation'})-[:ON_CHANNEL]->(channel:Channel), (contract)-[:DEFINES_CHANNEL]->(channel2:Channel {name:'waterlooChannel'}), (channel)-[relation:REFERENCES]->(channel2) return count(*) as Relations");
        assertThat(result.getColumns().get("Relations")).hasSize(1);

        TestResult result2 = query("MATCH (contract:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation{name: 'receive_WaterlooOperation'})-[:USING_MESSAGE]->(message:Message), (contract)-[:DEFINES_CHANNEL]->(:Channel {name:'waterlooChannel'})-[:SUPPORTS_MESSAGE]->(message2:Message), (message)-[relation:REFERENCES]->(message2) return count(*) as Relations");
        assertThat(result2.getColumns().get("Relations")).hasSize(1);

        TestResult result3 = query("MATCH (:AsyncAPI)-[r:REFERENCES]->(:AsyncAPI) RETURN count(r) as allRelations");
        assertThat(result3.getColumns().get("allRelations").get(0)).isEqualTo(8L);
        store.commitTransaction();
    }
}
