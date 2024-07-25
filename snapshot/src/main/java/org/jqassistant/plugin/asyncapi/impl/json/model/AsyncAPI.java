// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.components.Components;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.Info;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.Operation;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.Server;

@Getter
@Setter
@ToString
public class AsyncAPI  {

    public static final String ASYNCAPI_DEFAULT_VERSION = "3.0.0";

    @JsonProperty(value = "asyncapi")
    private String asyncapi = ASYNCAPI_DEFAULT_VERSION;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "info")
    private Info info;

    @JsonProperty(value = "defaultContentType")
    private String defaultContentType;

    @JsonProperty(value = "servers")
    private Map<String, Server> servers;

    @JsonProperty(value = "channels")
    private Map<String, ChannelObject> channels;

    @JsonProperty(value = "components")
    private Components components;

    @JsonProperty(value = "operations")
    private Map<String, Operation> operations;
}
