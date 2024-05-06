// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sqs;

public enum SQSChannelBindingDeduplicationScope {
    MESSAGE_GROUP("messageGroup"),
    QUEUE("queue");

    public final String type;

    SQSChannelBindingDeduplicationScope(String type) {
        this.type = type;
    }

    public static SQSChannelBindingDeduplicationScope fromString(String type) {
        return valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return this.type;
    }
}
