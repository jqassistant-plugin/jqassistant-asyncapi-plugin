package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSServerBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.server.JmsServerBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ListMapToStringMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ListMapToStringMapper.class })
@DecoratedWith(JmsServerBindingsMapperDecorator.class)
public interface JmsServerBindingsMapper extends DescriptorMapper<JMSServerBinding, JmsServerBindingsDescriptor> {

    JmsServerBindingsMapper INSTANCE = Mappers.getMapper(JmsServerBindingsMapper.class);

    @Mapping(target = "path", ignore = true)
    @Mapping(target = "name", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    JmsServerBindingsDescriptor toDescriptor(JMSServerBinding kafka, @Context Scanner scanner);

}
