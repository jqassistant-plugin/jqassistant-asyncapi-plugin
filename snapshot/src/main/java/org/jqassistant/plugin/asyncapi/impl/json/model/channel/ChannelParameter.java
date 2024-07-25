// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class ChannelParameter extends ReferenceObject {

    @JsonProperty("enum")
    private List<String> enumValues;

    @JsonProperty("default")
    private String defaultValue;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "examples")
    private List<String> examples;

    @JsonProperty(value = "location")
    private String location;

}
