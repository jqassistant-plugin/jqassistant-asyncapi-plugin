// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter


public enum KafkaChannelTopicCleanupPolicy {
    @JsonProperty("compact")
    COMPACT("compact"),
    @JsonProperty("delete")
    DELETE("delete");

    public final String type;

    KafkaChannelTopicCleanupPolicy(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toUpperCase();
    }
}
