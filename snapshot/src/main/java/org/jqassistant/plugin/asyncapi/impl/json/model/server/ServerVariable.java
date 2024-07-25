// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.server;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class ServerVariable  extends ReferenceObject {

    @JsonProperty(value = "enum")
    private List<String> enumValues;

    @JsonProperty("default")
    private String defaultValue;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "examples")
    private List<String> examples;
}
