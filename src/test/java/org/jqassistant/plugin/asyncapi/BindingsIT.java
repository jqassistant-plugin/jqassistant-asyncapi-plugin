package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.ArrayList;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.*;
import org.jqassistant.plugin.asyncapi.api.model.bindings.websockets.WsChannelBindingsDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BindingsIT extends AbstractPluginIT {

    ContractDescriptor contract;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(BindingsIT.class), "testAsyncApi/bindingsTest.yml");
        contract = getScanner().scan(file, "testAsyncApi/bindingsTest.yml", AsyncApiScope.CONTRACT);
    }

    @Test
    void channelBindings() {
        store.beginTransaction();
        //in components
        Query.Result<Query.Result.CompositeRowObject> channelBindings = store.executeQuery(
                "MATCH (:Components)-[:DEFINES_CHANNEL]->(channel:Channel {name:'oneFantasticChannel'})-[DEFINES_BINDINGS]-> (bindings:Channel_Bindings) return bindings");
        assertThat(channelBindings.hasResult()).isTrue();

        //kafka
        Query.Result<Query.Result.CompositeRowObject> kafkaBinding = store.executeQuery(
                "MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {name:'oneFantasticChannel'})-[DEFINES_BINDINGS]-> (:Channel_Bindings)-[DEFINES_KAFKA_BINDING]->(kafka:Kafka_Channel) return kafka");
        assertThat(kafkaBinding.hasResult()).isTrue();
        KafkaChannelBindingsDescriptor kafka = kafkaBinding.getSingleResult()
                .get("kafka", KafkaChannelBindingsDescriptor.class);
        assertThat(kafka.getTopic()).isEqualTo("my-specific-topic-name");
        assertThat(kafka.getPartitions()).isEqualTo(20);
        assertThat(kafka.getReplicas()).isEqualTo(3);
        assertThat(kafka.getBindingVersion()).isEqualTo("0.4.0");
        Query.Result<Query.Result.CompositeRowObject> topicConfiguration = store.executeQuery(
                "MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {name:'oneFantasticChannel'})-[DEFINES_BINDINGS]-> (:Channel_Bindings)-[DEFINES_KAFKA_BINDING]->(:Kafka_Channel)-[DEFINES_CONFIGURATION]->(topicConfig:Topic_Configuration) return topicConfig");
        assertThat(topicConfiguration.hasResult()).isTrue();
        TopicConfigurationDescriptor topigConfig = topicConfiguration.getSingleResult()
                .get("topicConfig", TopicConfigurationDescriptor.class);
        ArrayList<String> cleanupPolicy = new ArrayList<>();
        cleanupPolicy.add("delete");
        cleanupPolicy.add("compact");
        assertThat(topigConfig.getCleanupPolicy()).isEqualTo(cleanupPolicy.toArray());

        assertThat(topigConfig.getMaxMessageBytes()).isEqualTo(1048588);
        assertThat(topigConfig.getRetentionBytes()).isEqualTo(1000000000);
        assertThat(topigConfig.getDeleteRetentionMs()).isEqualTo(86400000);
        assertThat(topigConfig.getRetentionMs()).isEqualTo(604800000);
        assertThat(topigConfig.getConfluentKeySubjectNameStrategy()).isEqualTo("TopicNameStrategy");
        assertThat(topigConfig.getConfluentKeySchemaValidation()).isTrue();
        assertThat(topigConfig.getConfluentValueSubjectNameStrategy()).isEqualTo("TopicNameStrategy");
        assertThat(topigConfig.getConfluentValueSchemaValidation()).isFalse();
        //websockets
        Query.Result<Query.Result.CompositeRowObject> wsBinding = store.executeQuery(
                "MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {name:'oneFantasticChannel'})-[DEFINES_BINDINGS]-> (:Channel_Bindings)-[DEFINES_WEBSOCKETS_BINDING]->(ws:Websockets_Channel) return ws");
        assertThat(wsBinding.hasResult()).isTrue();
        WsChannelBindingsDescriptor ws = wsBinding.getSingleResult()
                .get("ws", WsChannelBindingsDescriptor.class);
        assertThat(ws.getMethod()).isEqualTo("specificMethod");
        assertThat(ws.getBindingVersion()).isEqualTo("0.2.0");
        //TODO: insert tests for Schema Objects

        //jms
        Query.Result<Query.Result.CompositeRowObject> jmsBinding = store.executeQuery(
                "MATCH (:Components)-[:DEFINES_CHANNEL]->(:Channel {name:'oneFantasticChannel'})-[DEFINES_BINDINGS]-> (:Channel_Bindings)-[DEFINES_JMS_BINDING]->(jms:Jms_Channel) return jms");
        assertThat(jmsBinding.hasResult()).isTrue();
        JmsChannelBindingsDescriptor jms = jmsBinding.getSingleResult()
                .get("jms", JmsChannelBindingsDescriptor.class);
        assertThat(jms.getDestination()).isEqualTo("user-sign-up");
        assertThat(jms.getDestinationType()).isEqualTo("fifo-queue");
        assertThat(jms.getBindingVersion()).isEqualTo("0.0.1");
        store.commitTransaction();
    }

    @Test
    void messageBindings() {
        store.beginTransaction();
        //in channel
        Query.Result<Query.Result.CompositeRowObject> messageBindings = store.executeQuery(
                "MATCH (:Message {name:'userSignupMessage'})-[DEFINES_BINDING]->(bindings:Message_Binding) return bindings");
        assertThat(messageBindings.hasResult()).isTrue();

        Query.Result<Query.Result.CompositeRowObject> jmsBinding = store.executeQuery(
                "MATCH (:Message {name:'userSignupMessage'})-[DEFINES_BINDING]->(:Message_Binding)-[DEFINES_JMS_BINDING]->(jms:Jms_Message) return jms");
        assertThat(jmsBinding.hasResult()).isTrue();
        JmsMessageBindingsDescriptor jms = jmsBinding.getSingleResult()
                .get("jms", JmsMessageBindingsDescriptor.class);
        assertThat(jms.getBindingVersion()).isEqualTo("0.3.2");

        Query.Result<Query.Result.CompositeRowObject> kafkaBinding = store.executeQuery(
                "MATCH (:Message {name:'userSignupMessage'})-[DEFINES_BINDING]->(:Message_Binding)-[DEFINES_KAFKA_BINDING]->(kafka:Kafka_Message) return kafka");
        assertThat(kafkaBinding.hasResult()).isTrue();
        KafkaMessageBindingsDescriptor kafka = kafkaBinding.getSingleResult()
                .get("kafka", KafkaMessageBindingsDescriptor.class);
        assertThat(kafka.getSchemaIdLocation()).isEqualTo("payload");
        assertThat(kafka.getSchemaIdPayloadEncoding()).isEqualTo("4");
        assertThat(kafka.getSchemaLookupStrategy()).isEqualTo("strategyClass");
        store.commitTransaction();
    }

    @Test
    void serverBindings() {
        store.beginTransaction();
        //in server
        Query.Result<Query.Result.CompositeRowObject> serverBindings = store.executeQuery(
                "MATCH (:Server {name:'oneServer'})-[DEFINES_BINDING]->(bindings:Server_Binding) return bindings");
        assertThat(serverBindings.hasResult()).isTrue();

        Query.Result<Query.Result.CompositeRowObject> jmsBinding = store.executeQuery(
                "MATCH (:Server {name:'oneServer'})-[DEFINES_BINDING]->(:Server_Binding)-[DEFINES_JMS_BINDING]->(jms:Jms_Server) return jms");
        assertThat(jmsBinding.hasResult()).isTrue();
        JmsServerBindingsDescriptor jms = jmsBinding.getSingleResult()
                .get("jms", JmsServerBindingsDescriptor.class);
        assertThat(jms.getBindingVersion()).isEqualTo("0.5.0");
        assertThat(jms.getJmsConnectionFactory()).isEqualTo("org.apache.activemq.ActiveMQConnectionFactory");
        assertThat(jms.getClientId()).isEqualTo("my-application-1");

        Query.Result<Query.Result.CompositeRowObject> kafkaBinding = store.executeQuery(
                "MATCH (:Server {name:'oneServer'})-[DEFINES_BINDING]->(:Server_Binding)-[DEFINES_KAFKA_BINDING]->(kafka:Kafka_Server) return kafka");
        assertThat(kafkaBinding.hasResult()).isTrue();
        KafkaServerBindingsDescriptor kafka = kafkaBinding.getSingleResult()
                .get("kafka", KafkaServerBindingsDescriptor.class);
        assertThat(kafka.getSchemaRegistryUrl()).isEqualTo("https://my-schema-registry.com");
        assertThat(kafka.getSchemaRegistryVendor()).isEqualTo("confluent");
        assertThat(kafka.getBindingVersion()).isEqualTo("0.7.0");
        store.commitTransaction();
    }

    @Test
    void operationBindings() {
        store.beginTransaction();
        //in operation
        Query.Result<Query.Result.CompositeRowObject> operationBindings = store.executeQuery(
                "MATCH (:Operation {name:'oneOperation'})-[DEFINES_BINDING]->(bindings:Operation_Binding) return bindings");
        assertThat(operationBindings.hasResult()).isTrue();

        Query.Result<Query.Result.CompositeRowObject> kafkaBinding = store.executeQuery(
                "MATCH (:Operation {name:'oneOperation'})-[DEFINES_BINDING]->(:Operation_Binding)-[DEFINES_KAFKA_BINDING]->(kafka:Kafka_Operation) return kafka");
        assertThat(kafkaBinding.hasResult()).isTrue();
        KafkaOperationBindingsDescriptor kafka = kafkaBinding.getSingleResult()
                .get("kafka", KafkaOperationBindingsDescriptor.class);
        assertThat(kafka.getBindingVersion()).isEqualTo("0.5.3");
        store.commitTransaction();
    }
}