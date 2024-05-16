// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public class PulsarServerBinding extends ReferenceObject {

    @JsonProperty(value = "tenant", defaultValue = "public")
    private String tenant;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.1.0")
    private String bindingVersion;
}
