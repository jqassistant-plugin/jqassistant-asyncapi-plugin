package org.jqassistant.plugin.asyncapi;

import java.io.File;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ComponentsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageReferencesIT extends AbstractPluginIT { /**tests the existence of messages at all possible locations and their references**/

    ComponentsDescriptor components;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(MessageReferencesIT.class), "testAsyncApi/messageReferencesTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/messageReferencesTest.yml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
        assertThat(contract).isNotNull();
    }

    @AfterEach
    public void closeTransaction() {
        store.commitTransaction();
    }

    @Test
    void tags() {


    }
}