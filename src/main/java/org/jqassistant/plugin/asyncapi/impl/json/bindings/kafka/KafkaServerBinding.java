// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;

/**
 * This object contains information about the server representation in Kafka.
 */


@Setter
@Getter
@ToString
public class KafkaServerBinding extends ServerBinding {

    KafkaServerBinding(){

    }

    @JsonProperty("schemaRegistryUrl")
    private String schemaRegistryUrl;

    @JsonProperty("schemaRegistryVendor")
    private String schemaRegistryVendor;


    @JsonProperty(value = "bindingVersion", defaultValue = "0.5.0")
    private String bindingVersion = "0.5.0";
}
