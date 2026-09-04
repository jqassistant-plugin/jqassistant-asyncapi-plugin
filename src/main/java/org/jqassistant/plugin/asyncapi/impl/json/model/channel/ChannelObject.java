// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBindings;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.Server;

@Getter
@Setter
@ToString
public class ChannelObject extends ReferenceObject {

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "messages")
    private Map<String, MessageObject> messages;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "servers")
    private List<Server> servers;

    @JsonProperty(value = "parameters")
    private Map<String, ChannelParameter> parameter;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "bindings")
    private ChannelBindings bindings;
}
