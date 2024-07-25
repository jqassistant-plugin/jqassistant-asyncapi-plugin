// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.info;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;

@Getter
@Setter
@ToString
public class Info extends ReferenceObject {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "version")
    private String version;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "termsOfService")
    private String termsOfService;

    @JsonProperty(value = "contact")
    private Contact contact;

    @JsonProperty(value = "license")
    private License license;

    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;
}
