// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Setter
@Getter
@ToString
public class KafkaServerBinding extends ReferenceObject {

    @JsonProperty("schemaRegistryUrl")
    private String schemaRegistryUrl;

    @JsonProperty("schemaRegistryVendor")
    private String schemaRegistryVendor;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.5.0")
    private String bindingVersion = "0.5.0";
}
