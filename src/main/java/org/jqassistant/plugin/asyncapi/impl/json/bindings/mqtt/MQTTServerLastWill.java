// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Last Will and Testament configuration. topic, qos, message and retain are properties of this object as shown below.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MQTTServerLastWill {

    /**
     * The topic where the Last Will and Testament message will be sent.
     */
    @JsonProperty("topic")
    private String topic;

    /**
     * Defines how hard the broker/client will try to ensure that the Last Will and Testament message is received.
     * Its value MUST be either 0, 1 or 2.
     */
    @JsonProperty("qos")
    private Integer qos;

    /**
     * Last Will message.
     */
    @JsonProperty("message")
    private String message;

    /**
     * Whether the broker should retain the Last Will and Testament message or not.
     */
    @JsonProperty("retain")
    private Boolean retain;
}
