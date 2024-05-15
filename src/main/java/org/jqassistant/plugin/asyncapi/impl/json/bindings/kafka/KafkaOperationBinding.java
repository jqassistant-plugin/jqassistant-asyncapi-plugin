// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import javax.xml.validation.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.schema.SchemaObject;

@Getter
@Setter
@ToString
public class KafkaOperationBinding extends OperationBinding {


    @JsonProperty("groupId")
    private SchemaObject groupId;

    @JsonProperty("clientId")
    private SchemaObject clientId;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.5.0")
    private String bindingVersion = "0.5.0";
}
