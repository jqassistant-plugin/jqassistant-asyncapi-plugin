package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperationsIT extends AbstractPluginIT {
    /**
     * tests an operation descriptor for its simple attributes and special properites (operation traits, operation bindings and operation reply)
     **/
    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(OperationsIT.class), "testAsyncApi/operationsTest.yaml");
        getScanner().scan(file, "testAsyncApi/operationsTest.yaml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
    }

    @Test
    public void simpleAttributes() {
        List<OperationDescriptor> operations =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(operations:Operation) return operations").getColumn("operations");
        assertThat(operations.size()).isEqualTo(2);

        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(operation:Operation {referenceableKey:'sendProcess'}) return operation");
        assertThat(result.hasResult()).isTrue();
        OperationDescriptor operationDescriptor = result.getSingleResult()
                .get("operation", OperationDescriptor.class);

        assertThat(operationDescriptor).isNotNull();
        assertThat(operationDescriptor.getReferenceableKey()).isEqualTo("sendProcess");
        assertThat(operationDescriptor.getTitle()).isEqualTo("Send101");
        assertThat(operationDescriptor.getSummary()).isEqualTo("Action to send something.");
        assertThat(operationDescriptor.getDescription()).isEqualTo("A longer description");
        assertThat(operationDescriptor.getAction()).isEqualTo("send");
        store.commitTransaction();
    }

    @Test
    public void channels() {
        List<ChannelDescriptor> channels =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:ON_CHANNEL]->(channel:Channel) return channel").getColumn("channel");
        assertThat(channels.size()).isEqualTo(1);
        store.commitTransaction();
    }
    //to add: security

    @Test
    public void tags() {
        List<TagDescriptor> tags =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:HAS_TAG]->(tag:Tag) return tag").getColumn("tag");
        assertThat(tags.size()).isEqualTo(3);
        store.commitTransaction();
    }

    @Test
    public void bindings() {
        //operation binding
        Query.Result<Query.Result.CompositeRowObject> bindings = store.executeQuery("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:DEFINES_BINDINGS]->(bindings:OperationBindings) return bindings");
        assertThat(bindings.hasResult()).isTrue();
        OperationBindingsDescriptor operationBindings = bindings.getSingleResult()
                .get("bindings", OperationBindingsDescriptor.class);
        assertThat(operationBindings).isNotNull();

        //operation binding: kafka
        Query.Result<Query.Result.CompositeRowObject> kafka = store.executeQuery("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:DEFINES_BINDINGS]->(:OperationBindings)-[:DEFINES_KAFKA_BINDING]->(kafka:KafkaOperation) return kafka");
        assertThat(kafka.hasResult()).isTrue();
        KafkaOperationBindingsDescriptor kafkaBinding = kafka.getSingleResult()
                .get("kafka", KafkaOperationBindingsDescriptor.class);
        assertThat(kafkaBinding).isNotNull();
        assertThat(kafkaBinding.getBindingVersion()).isEqualTo("0.5.0");
        store.commitTransaction();
    }

    @Test
    public void traits() {
        List<OperationTraitDescriptor> traits =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:DEFINES_TRAIT]->(trait:OperationTrait) return trait").getColumn("trait");
        assertThat(traits.size()).isEqualTo(1);
        store.commitTransaction();
    }

    @Test
    public void reply() {
        //operation reply
        Query.Result<Query.Result.CompositeRowObject> reply = store.executeQuery("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:USING_REPLY]->(reply:OperationReply) return reply");
        assertThat(reply.hasResult()).isTrue();
        OperationReplyDescriptor operationReply = reply.getSingleResult()
                .get("reply", OperationReplyDescriptor.class);
        assertThat(operationReply).isNotNull();

        //channel in reply
        List<ChannelDescriptor> replyChannel =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:USING_REPLY]->(:OperationReply)-[:ON_CHANNEL]->(channel:Channel) return channel").getColumn("channel");
        assertThat(replyChannel.size()).isEqualTo(1);
        store.commitTransaction();
    }

    @Test
    public void replyAddress() {
        //operation reply address
        Query.Result<Query.Result.CompositeRowObject> address = store.executeQuery("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:USING_REPLY]->(reply:OperationReply)-[:HAS_ADDRESS]->(address:OperationReplyAddress) return address");
        assertThat(address.hasResult()).isTrue();
        OperationReplyAddressDescriptor operationAddress = address.getSingleResult()
                .get("address", OperationReplyAddressDescriptor.class);
        assertThat(operationAddress).isNotNull();
        assertThat(operationAddress.getLocation()).isEqualTo("$message.header#/replyTo");
        store.commitTransaction();
    }

    @Test
    public void messages() {
        //messages
        List<MessageDescriptor> messages =
                query("MATCH (:AsyncAPI:Contract)-[:DEFINES_OPERATION]->(:Operation {referenceableKey:'sendProcess'})-[:USING_MESSAGE]->(message:Message) return message").getColumn("message");
        assertThat(messages.size()).isEqualTo(1);
        store.commitTransaction();
    }

}