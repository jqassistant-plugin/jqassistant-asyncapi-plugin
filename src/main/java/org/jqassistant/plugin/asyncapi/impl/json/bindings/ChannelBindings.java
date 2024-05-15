// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.websockets.WebSocketChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Setter
@Getter
@ToString
public class ChannelBindings extends ReferenceObject {

    public ChannelBindings() {
    }

    @JsonProperty(value = "kafka")
    private KafkaChannelBinding kafka;

    @JsonProperty(value = "amqp")
    private AMQPChannelBinding amqp;

    @JsonProperty(value = "jms")
    private JMSChannelBinding jms;

    @JsonProperty(value = "ws")
    private WebSocketChannelBinding ws;
}
