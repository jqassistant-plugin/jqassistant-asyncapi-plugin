// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar.PulsarServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Setter
@Getter
@ToString
public class ServerBindings extends ReferenceObject {

    /**
     * to be extended
     **/
    @JsonProperty(value = "kafka")
    private KafkaServerBinding kafka;

    @JsonProperty(value = "amqp")
    private AMQPServerBinding amqp;

    @JsonProperty(value = "jms")
    private JMSServerBinding jms;

    @JsonProperty(value = "pulsar")
    private PulsarServerBinding pulsar;
}
