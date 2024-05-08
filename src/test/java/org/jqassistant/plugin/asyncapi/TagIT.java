package org.jqassistant.plugin.asyncapi;

import java.io.File;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ComponentsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagIT extends AbstractPluginIT {
    /**
     * tests the existence of tags at all possible locations and their references
     **/

    ComponentsDescriptor components;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(TagIT.class), "testAsyncApi/tagReferencesTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/tagReferencesTest.yml", AsyncApiScope.CONTRACT);

    }

    @Test
    void tags() {

    }
}