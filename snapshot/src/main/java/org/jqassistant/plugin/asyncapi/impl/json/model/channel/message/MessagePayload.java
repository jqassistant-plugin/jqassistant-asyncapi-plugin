// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.channel.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.schema.MultiFormatSchema;
import org.jqassistant.plugin.asyncapi.impl.json.model.schema.SchemaObject;

@Getter
@Setter
@ToString
public class MessagePayload {
    private MultiFormatSchema multiFormatSchema;
    private SchemaObject schema;
    private MessageObject reference;

}
