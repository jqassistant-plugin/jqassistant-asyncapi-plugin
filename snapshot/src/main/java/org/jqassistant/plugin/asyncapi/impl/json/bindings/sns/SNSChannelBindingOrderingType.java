// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sns;

public enum SNSChannelBindingOrderingType {
    STANDARD("standard"),
    FIFO("FIFO");

    public final String type;

    SNSChannelBindingOrderingType(String type) {
        this.type = type;
    }

    public static SNSChannelBindingOrderingType fromString(String type) {
        return valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return this.type;
    }
}
