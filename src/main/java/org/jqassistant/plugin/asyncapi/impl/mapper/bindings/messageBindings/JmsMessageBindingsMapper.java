package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.message.JmsMessageBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(JmsMessageBindingsMapperDecorator.class)
public interface JmsMessageBindingsMapper extends DescriptorMapper<JMSMessageBinding, JmsMessageBindingsDescriptor> {

    JmsMessageBindingsMapper INSTANCE = Mappers.getMapper(JmsMessageBindingsMapper.class);

    @Mapping(target = "path", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "headers", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" }) //add Schema key
    @Override
    JmsMessageBindingsDescriptor toDescriptor(JMSMessageBinding binding, @Context Scanner scanner);

}
