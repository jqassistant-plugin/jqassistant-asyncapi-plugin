// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExternalDocumentation extends ReferenceObject {

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "url")
    private String url;
}
