package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorEnricher;

import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.AsyncAPI;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.URIMapper;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = { InfoMapper.class, ChannelsMapper.class, ComponentsMapper.class, OperationMapper.class, TagMapper.class, URIMapper.class, ServerMapper.class })
public interface AsyncApiMapper extends DescriptorEnricher<AsyncAPI, ContractDescriptor> {

    @Mapping(target = "asyncApiVersion", source = "asyncapi")
    @Override
    ContractDescriptor toDescriptor(AsyncAPI asyncApi, @MappingTarget ContractDescriptor contractDescriptor, @Context Scanner scanner);
}
