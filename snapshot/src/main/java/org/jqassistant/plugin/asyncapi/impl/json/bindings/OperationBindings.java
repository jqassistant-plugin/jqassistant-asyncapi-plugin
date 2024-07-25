// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Setter
@Getter
@ToString
public class OperationBindings extends ReferenceObject {

    /**
     * to be extended
     **/

    @JsonProperty(value = "kafka")
    private KafkaOperationBinding kafka;

    @JsonProperty(value = "amqp")
    private AMQPOperationBinding amqp;

}
