// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel.message;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class MessageExample extends ReferenceObject {

    @JsonProperty(value = "headers")
    private Map<String, Object> headers;

    @JsonProperty(value = "payload")
    private Map<String, Object> payload;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "summary")
    private String summary;
}
