// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.schema;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.components.ComponentSchema;

@Getter
@Setter
@ToString
public class SchemaObject extends ReferenceObject {

    @JsonProperty(value = "discriminator")
    private String discriminator;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "deprecated")
    private Boolean deprecated;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "properties")
    private Map<String, Object> properties;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "format")
    private String format;

    @JsonProperty
    private String pattern;

    @JsonProperty(value = "maximum")
    private BigDecimal maximum;

    @JsonProperty(value = "minimum")
    private BigDecimal minimum;

    @JsonProperty(value = "multipleOf")
    private BigDecimal multipleOf;

    @JsonProperty(value = "minLength")
    private Integer minLength;

    @JsonProperty(value = "maxLength")
    private Integer maxLength;

    @JsonProperty("enum")
    private List<String> enumValues;

    @JsonProperty(value = "exclusiveMinimum")
    private BigDecimal exclusiveMinimum;

    @JsonProperty(value = "exclusiveMaximum")
    private BigDecimal exclusiveMaximum;

    @JsonProperty(value = "examples")
    private List<Object> examples;

    @JsonProperty(value = "additionalProperties")
    private ComponentSchema additionalProperties;

    @JsonProperty(value = "required")
    private List<String> required;

    @JsonProperty(value = "allOf")
    private List<ComponentSchema> allOf;

    @JsonProperty(value = "oneOf")
    private List<ComponentSchema> oneOf;

    @JsonProperty(value = "anyOf")
    private List<ComponentSchema> anyOf;

    @JsonProperty(value = "const")
    private Object constValue;

    @JsonProperty(value = "not")
    private ComponentSchema not;

    @JsonProperty(value = "items")
    private ComponentSchema items;

    @JsonProperty(value = "uniqueItems")
    private Boolean uniqueItems;

    @JsonProperty(value = "minItems")
    private Integer minItems;

    @JsonProperty(value = "maxItems")
    private Integer maxItems;
}
