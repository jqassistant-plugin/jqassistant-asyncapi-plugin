// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel.message;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;

@Getter
@Setter
@ToString
public class MessageObject extends ReferenceObject {

    @JsonIgnore
    private String messageId;

    @JsonProperty(value = "headers")
    private MessageHeaders headers;

    @JsonProperty(value = "payload")
    private MessagePayload payload;

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
    private Map<String, MessageBinding> bindings;

    @JsonProperty(value = "examples")
    private List<MessageExample> examples;

    @JsonProperty(value = "traits")
    private List<MessageTrait> traits;

}
