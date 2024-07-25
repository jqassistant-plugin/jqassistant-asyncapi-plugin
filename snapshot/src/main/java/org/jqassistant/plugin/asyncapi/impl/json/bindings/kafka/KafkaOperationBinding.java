// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class KafkaOperationBinding extends ReferenceObject {

/*
    @JsonProperty("groupId")
    private SchemaObject groupId;

    @JsonProperty("clientId")
    private SchemaObject clientId; */

    @JsonProperty(value = "bindingVersion", defaultValue = "0.5.0")
    private String bindingVersion = "0.5.0";
}
