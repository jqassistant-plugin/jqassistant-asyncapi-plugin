// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import javax.xml.validation.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.schema.SchemaObject;

/**
 * This object contains information about the message representation in Kafka.
 */
@Getter
@Setter
@ToString
public class KafkaMessageBinding extends MessageBinding {

    @JsonProperty(value = "key")
    private SchemaObject key; //temporary solution

    @JsonProperty(value = "schemaIdLocation")
    private String schemaIdLocation;

    @JsonProperty(value = "schemaIdPayloadEncoding")
    private String schemaIdPayloadEncoding;

    @JsonProperty(value = "schemaLookupStrategy")
    private String schemaLookupStrategy;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.5.0" )
    private String bindingVersion;
}
