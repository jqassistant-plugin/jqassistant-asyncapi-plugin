// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.server;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;

@Getter
@Setter
@ToString
public class Server extends ReferenceObject {

    @JsonProperty(value = "host")
    private String host;

    @JsonProperty(value = "protocol")
    private String protocol;

    @JsonProperty(value = "protocolVersion")
    private String protocolVersion;

    @JsonProperty(value = "pathname")
    private String pathName;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "variables")
    private Map<String, ServerVariable> variables;

    @JsonProperty(value = "security")
    private List<SecurityScheme> security;

    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "bindings")
    private Map<String, ServerBinding> bindings;

}
