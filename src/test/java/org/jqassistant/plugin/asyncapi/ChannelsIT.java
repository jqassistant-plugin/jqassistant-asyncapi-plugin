package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChannelsIT extends AbstractPluginIT {

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(ChannelsIT.class), "testAsyncApi/channelsTest.yml");
        getScanner().scan(file, "testAsyncApi/channelsTest.yml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
    }

    @Test
    void channels() {
        Query.Result<Query.Result.CompositeRowObject> resultC = store.executeQuery("MATCH (:Components)-[:DEFINES_CHANNEL]->(channel:Channel {referenceableKey:'secondChannel'}) return channel");
        assertThat(resultC.hasResult()).isTrue();
        ChannelDescriptor channel = resultC.getSingleResult()
                .get("channel", ChannelDescriptor.class);
        assertThat(channel).isNotNull();
        assertThat(channel.getAddress()).isEqualTo("users.{userId}");
        assertThat(channel.getReferenceableKey()).isEqualTo("secondChannel");
        assertThat(channel.getDescription()).isEqualTo("This channel is used to exchange messages about user events.");
        store.commitTransaction();
    }

    @Test
    void messages() {
        List<MessageDescriptor> messages =
                query("MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {referenceableKey:'secondChannel'})-[:SUPPORTS_MESSAGE]->(messages:Message) return messages").getColumn("messages");
        assertThat(messages.size()).isEqualTo(2);
        store.commitTransaction();
    }

    @Test
    void parameters() {
        List<ParametersDescriptor> parameters =
                query("MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {referenceableKey:'secondChannel'})-[:INCLUDES_PARAMETERS]->(parameters:Parameters) return parameters").getColumn("parameters");
        assertThat(parameters.size()).isEqualTo(1);
        store.commitTransaction();
    }

    @Test
    void servers() {
        List<ServerDescriptor> servers =
                query("MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {referenceableKey:'secondChannel'})-[:IN_SERVER]->(servers:Server) return servers").getColumn("servers");
        assertThat(servers.size()).isEqualTo(2);
        store.commitTransaction();


    }

}