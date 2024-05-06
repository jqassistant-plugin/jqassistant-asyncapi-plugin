// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;

@Builder
public class AMQPOperationBinding extends OperationBinding {

    @Builder.Default
    @JsonProperty("expiration")
    private Integer expiration = 0;

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

    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.3.0";
}
