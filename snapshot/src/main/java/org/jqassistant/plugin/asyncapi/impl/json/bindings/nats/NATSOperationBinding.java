// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.nats;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public class NATSOperationBinding extends ReferenceObject {

    @JsonProperty("queue")
    private String queue;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.1.0")
    private String bindingVersion;
}
