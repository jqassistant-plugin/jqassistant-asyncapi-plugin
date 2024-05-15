// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;

@Getter
@Setter
@ToString
public class AMQPChannelBinding  {

    @JsonProperty(value = "is", defaultValue = "routingKey") //quick fix: should actually be an enum
    private String is;

    @JsonProperty("exchange")
    private AMQPChannelExchange exchange;

    @JsonProperty("queue")
    private AMQPChannelQueue queue;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.3.0")
    private String bindingVersion;
}
