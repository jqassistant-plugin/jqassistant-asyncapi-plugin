package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("OperationReply")
public interface OperationReplyDescriptor extends ReferenceableDescriptor{

    @Relation("HAS_ADDRESS")
    OperationReplyAddressDescriptor getAddress();

    void setAddress(OperationReplyAddressDescriptor address);

    @Relation("DEFINES_CHANNEL")
    ChannelDescriptor getChannel();

    void setChannel(ChannelDescriptor channel); // is reference

    @Relation("DEFINES_MESSAGE")
    List<MessageDescriptor> getMessages();

    void setMessages(List<MessageDescriptor> messages);
}
