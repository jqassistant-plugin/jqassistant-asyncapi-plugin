// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class AMQPOperationBinding extends ReferenceObject {

    @JsonProperty(value = "expiration", defaultValue = "0")
    private Integer expiration;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("cc")
    private List<String> cc;

    @JsonProperty("priority")
    private Integer priority;

    @JsonProperty("deliveryMode")
    private Integer deliveryMode;

    @JsonProperty("mandatory")
    private Boolean mandatory;

    @JsonProperty("bcc")
    private List<String> bcc;

    @JsonProperty("timestamp")
    private Boolean timestamp;

    @JsonProperty("ack")
    private Boolean ack;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.3.0")
    private String bindingVersion = "0.3.0";
}
