package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class LocalOperationMappingIT extends AbstractPluginIT {

    @Test
    void sendsToOerationsInOneContract() throws RuleException {
        File file = new File(getClassesDirectory(LocalOperationMappingIT.class), "testAsyncApi/resolveChannelAddressTest3.yml");
        getScanner().scan(file, "testAsyncApi/resolveChannelAddressTest3.yml", AsyncApiScope.CONTRACT);

        //WHEN
        applyConcept("jqassistant-plugin-asyncapi:OperationSendsToOperation");

        //THEN
        TestResult result = query("MATCH (a:Contract:AsyncAPI)-[:DEFINES_OPERATION]-(o1:Operation {action: 'send'}), (a)-[:DEFINES_OPERATION]-(o2:Operation {action: 'receive'}), (o1)-[:SENDS_TO]->(o2) RETURN o1.referenceableKey as key1, o2.referenceableKey as key2");
        String name = result.getColumn("key1").get(0).toString();
        String name2 = result.getColumn("key2").get(0).toString();
        assertThat(name).isEqualTo("send_WaterlooOperation");
        assertThat(name2).isEqualTo("receive_WaterlooOperation");

    }

}
