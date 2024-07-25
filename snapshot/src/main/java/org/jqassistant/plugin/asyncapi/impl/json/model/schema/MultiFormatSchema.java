// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MultiFormatSchema {

    @JsonProperty(value = "schemaFormat")
    private String schemaFormat = SchemaFormat.DEFAULT.toString();

    @JsonProperty(value = "schema")
    private Object schema;
}
