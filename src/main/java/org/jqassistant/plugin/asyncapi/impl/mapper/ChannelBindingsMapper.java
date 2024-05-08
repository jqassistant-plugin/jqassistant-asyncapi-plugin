package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.ChannelBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper
@DecoratedWith(ChannelBindingsMapperDecorator.class)
public interface ChannelBindingsMapper extends ReferenceableObjectMapper<ChannelBinding, ChannelBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ChannelBindingsDescriptor toDescriptor(ChannelBinding channelBinding, @Context Scanner scanner);

    @Override
    default List<ChannelBindingsDescriptor> toDescriptors(Map<String, ChannelBinding> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ChannelBindingsDescriptor> toDescriptors(List<ChannelBinding> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}