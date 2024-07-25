package org.jqassistant.plugin.asyncapi;

import java.io.File;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.InfoDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SchemasIT extends AbstractPluginIT {

    InfoDescriptor info;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(SchemasIT.class), "testAsyncApi/schemasInComponents.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/schemasInComponents.yml", AsyncApiScope.CONTRACT);
    }

    @Test
    void simpleAttributes() {
    }

}