// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AMQPChannelExchange {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private AMQPChannelExchangeType type;

    @JsonProperty("durable")
    private Boolean durable;

    @JsonProperty("autoDelete")
    private Boolean autoDelete;

    /**
     * The virtual host of the exchange. Defaults to /.
     */
    @JsonProperty(value = "vhost", defaultValue = "/")
    private String vhost;
}
