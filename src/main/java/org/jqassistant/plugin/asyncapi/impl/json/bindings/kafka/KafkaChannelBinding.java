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

}
