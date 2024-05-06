// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.operation;

public enum OperationAction {
    SEND("send"),
    RECEIVE("receive");

    public final String type;

    OperationAction(String type) {
        this.type = type;
    }

    public static OperationAction fromString(String type) {
        return valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return this.type;
    }
}
