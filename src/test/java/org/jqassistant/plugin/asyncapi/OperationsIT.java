package org.jqassistant.plugin.asyncapi;

import java.io.File;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.InfoDescriptor;
import org.junit.jupiter.api.BeforeEach;

class OperationsIT extends AbstractPluginIT {
    /**
     * tests an operation descriptor for its simple attributes and special properites (operation traits, operation bindings and operation reply
     **/

    InfoDescriptor info;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(OperationsIT.class), "testAsyncApi/operationsTest.yaml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/operationsTest.yaml", AsyncApiScope.CONTRACT);

    }

}