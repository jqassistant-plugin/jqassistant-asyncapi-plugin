// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.googlepubsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class GooglePubSubMessageBinding extends ReferenceObject {

    @JsonProperty("attributes")
    private Object attributes;

    @JsonProperty("orderingKey")
    private String orderingKey;

    @JsonProperty("schema")
    private GooglePubSubSchema schema;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.2.0")
    private String bindingVersion;
}
