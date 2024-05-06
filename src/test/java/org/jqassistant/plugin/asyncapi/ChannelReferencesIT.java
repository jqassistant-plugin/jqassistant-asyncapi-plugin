package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ChannelDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ComponentsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChannelReferencesIT extends AbstractPluginIT {
    /**
     * tests the existence of channels at all possible locations and their references
     **/

    ComponentsDescriptor components;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(ChannelReferencesIT.class), "testAsyncApi/channelReferencesTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/channelReferencesTest.yml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
        assertThat(contract).isNotNull();
    }

    @AfterEach
    public void closeTransaction() {
        store.commitTransaction();
    }

    @Test
    void channels() {
        List<ChannelDescriptor> channels = components.getChannels();
        assertThat(channels).isNotNull();
        assertThat(channels).hasSize(1);
        ChannelDescriptor channel = channels.get(0);
        assertThat(channel.getName()).isEqualTo("userSignedUp");
        assertThat(channel.getTitle()).isEqualTo("channel1.3"); //TODO: title and name should not be the same
        assertThat(channel.getAddress()).isEqualTo("user_signedup");
        assertThat(channel.getDescription()).isEqualTo("This channel contains a message per each user who signs up in our application.");
        assertThat(channel.getSummary()).isNull();

    }
}