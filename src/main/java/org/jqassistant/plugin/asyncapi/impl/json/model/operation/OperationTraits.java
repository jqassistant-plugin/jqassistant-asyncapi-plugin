// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.operation;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;

@Getter
@Setter
@ToString
public class OperationTraits extends ReferenceObject {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "security")
    private SecurityScheme security;

    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "bindings")
    private Map<String, OperationBinding> bindings;

}
