package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ParametersDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelParameter;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ParametersMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ListToStringMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ListToStringMapper.class, config = DescriptorMapperConfig.class)
@DecoratedWith(ParametersMapperDecorator.class)
public interface ParametersMapper extends ReferenceableObjectMapper<ChannelParameter, ParametersDescriptor> {

    ParametersMapper INSTANCE = Mappers.getMapper(ParametersMapper.class);

    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "enum", source = "enumValues")
    @Mapping(target = "default", source = "defaultValue")
    @Mapping(target = "name", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ParametersDescriptor toDescriptor(ChannelParameter parameters, @Context Scanner scanner);

    default List<ParametersDescriptor> toDescriptors(Map<String, ChannelParameter> parameters, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    default List<ParametersDescriptor> toDescriptors(List<ChannelParameter> parameters, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}
