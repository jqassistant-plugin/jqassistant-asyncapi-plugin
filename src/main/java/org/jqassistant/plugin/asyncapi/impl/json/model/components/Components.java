// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.components;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelParameter;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageTrait;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.Operation;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReply;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReplyAddress;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationTraits;
import org.jqassistant.plugin.asyncapi.impl.json.model.schema.SchemaObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.Server;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.ServerVariable;

@Getter
@Setter
@ToString
public class Components extends ReferenceObject {
    @JsonProperty(value = "schemas")
    private Map<String, SchemaObject> schemas;

    @JsonProperty(value = "servers")
    private Map<String, Server> servers;

    @JsonProperty(value = "channels")
    private Map<String, ChannelObject> channels;

    @JsonProperty(value = "operations")
    private Map<String, Operation> operations;

    @JsonProperty(value = "messages")
    private Map<String, MessageObject> messages;

    @JsonProperty(value = "securitySchemes")
    private Map<String, SecurityScheme> securitySchemes;

    @JsonProperty(value = "serverVariables")
    private Map<String, ServerVariable> serverVariables;

    @JsonProperty(value = "parameters")
    private Map<String, ChannelParameter> parameters;

    @JsonProperty(value = "correlationIds")
    private Map<String, CorrelationID> correlationIds;

    @JsonProperty(value = "replies")
    private Map<String, OperationReply> replies;

    @JsonProperty(value = "replyAddresses")
    private Map<String, OperationReplyAddress> replyAddresses;


    @JsonProperty(value = "externalDocs")
    private ExternalDocumentation externalDocs;

    @JsonProperty(value = "tags")
    private Map<String, Tag> tags;

    @JsonProperty(value = "operationTraits")
    private Map<String, OperationTraits> operationTraits;

    @JsonProperty(value = "messageTraits")
    private Map<String, MessageTrait> messageTraits;

    @JsonProperty(value = "serverBindings")
    private Map<String, ServerBinding> serverBindings;

    @JsonProperty(value = "channelBindings")
    private Map<String, ChannelBinding> channelBindings;

    @JsonProperty(value = "operationBindings")
    private Map<String, OperationBinding> operationBindings;

    @JsonProperty(value = "messageBindings")
    private Map<String, MessageBinding> messageBindings;
}
