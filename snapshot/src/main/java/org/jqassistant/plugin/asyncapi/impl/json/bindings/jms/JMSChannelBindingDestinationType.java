// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.jms;

public enum JMSChannelBindingDestinationType {
    QUEUE("queue"),
    FIFO_QUEUE("fifo-queue");

    public final String type;

    JMSChannelBindingDestinationType(String type) {
        this.type = type;
    }

    public static JMSChannelBindingDestinationType fromString(String type) {
        return valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return this.type;
    }
}
