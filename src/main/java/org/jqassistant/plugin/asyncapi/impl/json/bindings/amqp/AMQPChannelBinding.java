// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;

@Getter
@Setter
@ToString
public class AMQPChannelBinding extends ChannelBinding {

    @JsonProperty(value = "is", required = true, defaultValue = "routingKey")
    private AMQPChannelType is;

    @JsonProperty("exchange")
    private AMQPChannelExchange exchange;

    @JsonProperty("queue")
    private AMQPChannelQueue queue;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.3.0")
    private String bindingVersion;
}
