package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChannelsIT extends AbstractPluginIT {


    InfoDescriptor info;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(ChannelsIT.class), "testAsyncApi/channelsTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/channelsTest.yml", AsyncApiScope.CONTRACT);
    }

    @Test
    void channels() {
        store.beginTransaction();
        //contract
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (contract:Contract) RETURN contract");
        assertThat(result.hasResult()).isTrue();
        ContractDescriptor contract = result.getSingleResult()
                .get("contract", ContractDescriptor.class);
        assertThat(contract).isNotNull();

        //simple attributes
        Query.Result<Query.Result.CompositeRowObject> resultC = store.executeQuery("MATCH (:Components)-[:HAS_CHANNEL]->(channel:Channel {name:'secondChannel'}) return channel");
        assertThat(resultC.hasResult()).isTrue();
        ChannelDescriptor channel = resultC.getSingleResult()
                .get("channel", ChannelDescriptor.class);
        assertThat(channel).isNotNull();
        assertThat(channel.getAddress()).isEqualTo("users.{userId}");
        assertThat(channel.getName()).isEqualTo("secondChannel");
        assertThat(channel.getDescription()).isEqualTo("This channel is used to exchange messages about user events.");

        //messages in channels
        List<MessageDescriptor> messages =
                query("MATCH (:Components)-[:HAS_CHANNEL]->(:Channel {name:'secondChannel'})-[:HAS_MESSAGE]->(messages:Message) return messages").getColumn("messages");
        assertThat(messages.size()).isEqualTo(2);

        //parameters in channels
        List<ParametersDescriptor> parameters =
                query("MATCH (:Components)-[:HAS_CHANNEL]->(:Channel {name:'secondChannel'})-[:HAS_PARAMETERS]->(parameters:Parameters) return parameters").getColumn("parameters");
        assertThat(parameters.size()).isEqualTo(1);

        //parameters in channels
        List<ServerDescriptor> servers =
                query("MATCH (:Components)-[:HAS_CHANNEL]->(:Channel {name:'secondChannel'})-[:HAS_SERVER]->(servers:Server) return servers").getColumn("servers");
        assertThat(servers.size()).isEqualTo(2);

        store.commitTransaction();

    }

}