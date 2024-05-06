// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBinding;

@Getter
@Setter
@ToString
public class AMQPMessageBinding extends MessageBinding {
    @JsonProperty("contentEncoding")
    private String contentEncoding;

    @JsonProperty("messageType")
    private String messageType;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @JsonProperty(value = "bindingVersion", defaultValue = "0.3.0")
    private String bindingVersion;
}
