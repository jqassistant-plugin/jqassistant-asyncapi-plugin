// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.websockets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@ToString
@Setter
@Getter
public class WebSocketChannelBinding extends ReferenceObject {

    @JsonProperty("method")
    private String method;

/*    @JsonProperty("query")
    private Schema query;

    @JsonProperty("headers")
    private Schema headers; */

    @JsonProperty(value = "bindingVersion", defaultValue = "0.1.0")
    private String bindingVersion;
}
