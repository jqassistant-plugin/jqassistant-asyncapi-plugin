// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AMQPChannelQueue {

    @JsonProperty("name")
    private String name;

    @JsonProperty("durable")
    private Boolean durable;

    @JsonProperty("exclusive")
    private Boolean exclusive;

    @JsonProperty("autoDelete")
    private Boolean autoDelete;

    @JsonProperty(value = "vhost", defaultValue = "/")
    private String vhost;
}
