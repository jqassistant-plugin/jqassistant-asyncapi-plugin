package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class bindingsInChannelIT extends AbstractPluginIT {

    ContractDescriptor contract;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(bindingsInChannelIT.class), "testAsyncApi/bindingsTest.yml");
        contract = getScanner().scan(file, "testAsyncApi/bindingsTest.yml", AsyncApiScope.CONTRACT);
    }

    @Test
    void basic() {
        store.beginTransaction();
        assertThat(contract).isNotNull();
        ComponentsDescriptor components = contract.getComponents();
        assertThat(components).isNotNull();
        List<ChannelDescriptor> channels = components.getChannels();
        assertThat(channels).isNotNull();
        store.commitTransaction();
    }

}