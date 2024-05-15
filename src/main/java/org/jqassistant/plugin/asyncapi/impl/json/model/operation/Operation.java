// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.operation;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBindings;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;

@Getter
@Setter
@ToString
public class Operation extends ReferenceObject {

    @JsonProperty(value = "action")
    private String action;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonProperty(value = "channel")
    private List<ChannelObject> channel;
    /*TODO: This single ChannelObject should actually not be converted to a List. This workaround comes with the current state of the ReferenceMapper.class,
            that checks objects for being a reference to not override their attributes (Method mapValueAttributes()) before mapping. In the case an Object being
            a single object and not a form of collection, the mapping would not take place at all.  */

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "security")
    private List<SecurityScheme> security;

    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "bindings")
    private OperationBindings bindings;

    @JsonProperty(value = "traits")
    private List<OperationTraits> traits;

    @JsonProperty(value = "messages")
    private List<MessageObject> messages;

    @JsonProperty(value = "reply")
    private OperationReply reply;
}
