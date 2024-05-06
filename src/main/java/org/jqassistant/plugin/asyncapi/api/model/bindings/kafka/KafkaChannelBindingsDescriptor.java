package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;

@Label("Kafka_Channel")
public interface KafkaChannelBindingsDescriptor extends ChannelBindingsDescriptor , ReferenceDescriptor {

    String getTopic();

    void setTopic(String topic);

    int getPartitions();

    void setPartitions(int partitions);

    int getReplicas();

    void setReplicas(int replicas);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

    @Relation("HAS_CONFIGURATION")
    TopicConfigurationDescriptor getTopicConfiguration();

    void setTopicConfiguration(TopicConfigurationDescriptor topicConfiguration);

}