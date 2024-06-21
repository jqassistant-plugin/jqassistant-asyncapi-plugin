package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Operation_Reply")
public interface OperationReplyDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    @Relation("HAS_ADDRESS")
    OperationReplyAddressDescriptor getAddress();

    void setAddress(OperationReplyAddressDescriptor address);

    @Relation("ON_CHANNEL")
    ChannelDescriptor getChannel();

    void setChannel(ChannelDescriptor channel); // is reference

    @Relation("USING_MESSAGE")
    List<MessageDescriptor> getMessages();

    void setMessages(List<MessageDescriptor> messages);
}
