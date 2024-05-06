// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;

@Getter
@Setter
@ToString
public class KafkaChannelBinding extends ChannelBinding {

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("partitions")
    private Integer partitions;

    @JsonProperty("replicas")
    private Integer replicas;

    @JsonProperty("topicConfiguration")
    private KafkaChannelTopicConfiguration topicConfiguration;

    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.5.0";

    public KafkaChannelBinding(String topic, Integer partitions, Integer replicas, KafkaChannelTopicConfiguration topicConfiguration, String bindingVersion) {
        this.topic = topic;
        this.partitions = partitions;
        this.replicas = replicas;
        this.topicConfiguration = topicConfiguration;
        this.bindingVersion = bindingVersion;
    }

    public KafkaChannelBinding() {
    }

}
