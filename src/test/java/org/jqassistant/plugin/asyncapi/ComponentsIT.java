package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentsIT extends AbstractPluginIT {
    /**
     * tests the existence of all components and their simple attributes
     **/

    ComponentsDescriptor components;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(ComponentsIT.class), "testAsyncApi/componentsTest.yaml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/componentsTest.yaml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
        assertThat(contract).isNotNull();
        components = contract.getComponents();
        assertThat(components).isNotNull();
    }

    //TODO: test if absent descriptors are actually absent
    @AfterEach
    public void closeTransaction() {
        store.commitTransaction();
    }

    @Test
    void tags() {
        assertThat(components.getTags()).isNotNull();
        for (TagDescriptor tag : components.getTags()) {
            assertThat(tag.getName()).isEqualTo("kafka");
            assertThat(tag.getDescription()).isEqualTo("Resources relating to Kafka clusters");
        }
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

    @Test
    void messages() {
        List<MessageDescriptor> messages = components.getMessages();
        assertThat(messages.size()).isEqualTo(1);
        MessageDescriptor message = messages.get(0);
        assertThat(message.getName()).isEqualTo("SomethingDoing"); //actual attribute name gets overritten by key in map
        assertThat(message.getTitle()).isEqualTo("Something Progress");
        assertThat(message.getSummary()).isEqualTo("notification with something progress information");
        assertThat(message.getContentType()).isEqualTo("application/json");
        assertThat(message.getTags()).isNull();
    }

    /* @Test
    void schemas() {    not yet supported
    }*/

    @Test
    void parameters() {
        List<ParametersDescriptor> parameters = components.getParameters();
        assertThat(parameters.size()).isEqualTo(1);
        ParametersDescriptor parameter = parameters.get(0);
        assertThat(parameter.getName()).isEqualTo("userId");
        assertThat(parameter.getDescription()).isEqualTo("Id of the user.");
        assertThat(parameter.getLocation()).isEqualTo("$message.payload#/user/id");
        assertThat(parameter.getEnum()).isEqualTo("[I, am, an, enum]");
        assertThat(parameter.getDefault()).isEqualTo("test");
        assertThat(parameter.getExamples()).isEqualTo("[one  brilliant example, another example]");
    }

    @Test
    void externalDocs() {
        ExternalDocsDescriptor externalDocs = components.getExternalDocs();
        assertThat(externalDocs).isNotNull();
        assertThat(externalDocs.getDescription()).isEqualTo("More info about the components");
        assertThat(externalDocs.getUrl()).isEqualTo("https://ibm.github.io/event-streams/");
    }

    /* @Test
    void operationTraits() {    not yet supported
    }*/

    /* @Test
    void messageTraits() {    not yet supported
    }*/

}