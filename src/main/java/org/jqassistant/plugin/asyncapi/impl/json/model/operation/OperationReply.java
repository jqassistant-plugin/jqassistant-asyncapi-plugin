// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.operation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;

@Getter
@Setter
@ToString
public class OperationReply extends ReferenceObject {

    @JsonProperty("address")
    private OperationReplyAddress address;

    @JsonProperty("channel")
    private ChannelObject channel;

    @JsonProperty("messages")
    private List<MessageObject> messages;
}
