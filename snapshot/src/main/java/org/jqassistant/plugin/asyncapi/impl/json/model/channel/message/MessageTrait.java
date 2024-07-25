// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBindings;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;

@Getter
@Setter
@ToString
public class MessageTrait extends ReferenceObject {

    @JsonProperty(value = "headers")
    private Object headers; //messageHeaders

    @JsonProperty(value = "correlationId")
    private CorrelationID correlationId;

    @JsonProperty(value = "contentType")
    private String contentType;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "bindings")
    private MessageBindings bindings;

    @JsonProperty(value = "examples")
    private List<MessageExample> examples;

}
