// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar.PulsarMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.websockets.WebSocketMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Setter
@Getter
@ToString
public class MessageBindings extends ReferenceObject {

    public MessageBindings() {
    }

    /**
     * to be extended
     **/

    @JsonProperty(value = "kafka")
    private KafkaMessageBinding kafka;

    @JsonProperty(value = "amqp")
    private AMQPMessageBinding amqp;

    @JsonProperty(value = "jms")
    private JMSMessageBinding jms;

    @JsonProperty(value = "pulsar")
    private PulsarMessageBinding pulsar;

    @JsonProperty(value = "ws")
    private WebSocketMessageBinding ws;

}
