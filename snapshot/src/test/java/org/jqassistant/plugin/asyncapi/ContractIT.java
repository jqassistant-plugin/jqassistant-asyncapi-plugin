package org.jqassistant.plugin.asyncapi;

import java.io.File;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContractIT extends AbstractPluginIT {

    @Test
    void contractTest() {
        File file = new File(getClassesDirectory(ContractIT.class), "testAsyncApi/contractTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/contractTest.yml", AsyncApiScope.CONTRACT);
        assertThat(contract).isNotNull();
        store.beginTransaction();
        assertThat(contract.getAsyncApiVersion()).isEqualTo("3.0.0");
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (contract:Contract) RETURN contract");
        assertThat(result.hasResult()).isTrue();
        ContractDescriptor contract2 = result.getSingleResult()
                .get("contract", ContractDescriptor.class);
        assertThat(contract2).isNotNull();
        store.commitTransaction();
    }

}
