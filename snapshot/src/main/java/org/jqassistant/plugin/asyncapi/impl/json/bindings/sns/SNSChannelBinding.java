// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sns;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
@ToString
public class SNSChannelBinding {

    @JsonProperty("name")
    private String name;

    @JsonProperty("ordering")
    private SNSChannelBindingOrdering ordering;

    @JsonProperty("policy")
    private SNSChannelBindingPolicy policy;

    @JsonProperty("tags")
    private Map<String, String> tags;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.1.0")
    private String bindingVersion;
}
