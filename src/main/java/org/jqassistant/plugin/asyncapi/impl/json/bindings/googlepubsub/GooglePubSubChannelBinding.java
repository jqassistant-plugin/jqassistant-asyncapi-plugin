// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.googlepubsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GooglePubSubChannelBinding {

    @JsonProperty("labels")
    private Object labels;

    @JsonProperty("messageRetentionDuration")
    private String messageRetentionDuration;

    @JsonProperty("messageStoragePolicy")
    private GooglePubSubMessageStoragePolicy messageStoragePolicy;

    @JsonProperty("schemaSettings")
    private GooglePubSubSchemaSettings schemaSettings;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.2.0")
    private String bindingVersion;
}
