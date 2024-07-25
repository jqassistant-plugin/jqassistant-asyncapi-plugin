package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel.JmsChannelBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(JmsChannelBindingsMapperDecorator.class)
public interface JmsChannelBindingsMapper extends DescriptorMapper<JMSChannelBinding, JmsChannelBindingsDescriptor> {

    JmsChannelBindingsMapper INSTANCE = Mappers.getMapper(JmsChannelBindingsMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    JmsChannelBindingsDescriptor toDescriptor(JMSChannelBinding binding, @Context Scanner scanner);

}
