package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.JmsChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class JmsChannelBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<JMSChannelBinding, JmsChannelBindingsDescriptor>
        implements JmsChannelBindingsMapper {

    protected JmsChannelBindingsMapperDecorator(JmsChannelBindingsMapper mapper) {
        super("ws", JmsChannelBindingsDescriptor.class, mapper);
    }

    @Override
    public JmsChannelBindingsDescriptor toDescriptor(JMSChannelBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}