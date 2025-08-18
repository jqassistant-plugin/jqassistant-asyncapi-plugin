package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("AmqpOperation")
public interface AmqpOperationBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    int getExpiration();

    void setExpiration(int expiration);

    String getUserId();

    void setUserId(String userId);

    String getCC();

    void setCC(String cc); //is an Array [String]

    int getPriority();

    void setPriority(int priority);

    int getDeliveryMode();

    void setDeliveryMode(int deliveryMode);

    boolean getMandatory();

    void setMandatory(boolean mandatory);

    String getBcc();

    void setBcc(String bcc); //is an Array [String]

    boolean getTimeStamp();

    void setTimeStamp(boolean timeStamp);

    boolean getAck();

    void setAck(boolean ack);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}