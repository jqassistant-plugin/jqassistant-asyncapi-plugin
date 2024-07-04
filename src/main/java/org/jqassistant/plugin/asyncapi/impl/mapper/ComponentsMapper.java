package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.ComponentsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.components.Components;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.ChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { TagMapper.class, ChannelsMapper.class, ChannelBindingsMapper.class, ExternalDocsMapper.class, MessagesMapper.class, ParametersMapper.class, OperationMapper.class,
        ComponentsCorrelationIdMapper.class, ServerVariablesMapper.class, ServerMapper.class, ComponentsMessageTraitMapper.class, ComponentsOperationTraitMapper.class,
        OperationReplyAddressMapper.class, OperationReplyMapper.class, SecuritySchemesMapper.class })
@DecoratedWith(ComponentsMapperDecorator.class)
public interface ComponentsMapper extends DescriptorMapper<Components, ComponentsDescriptor> {

    ComponentsMapper INSTANCE = Mappers.getMapper(ComponentsMapper.class);

    @ReferenceableObjectMapping
    @Mapping(target = "operationReplyAddresses", source = "replyAddresses")
    @Mapping(target = "operationReplies", source = "replies")
    @BeanMapping(ignoreUnmappedSourceProperties = {"reference", "schemas",  "serverBindings",  "operationBindings",
            "messageBindings" })

    @Override
    ComponentsDescriptor toDescriptor(Components components, @Context Scanner scanner);
}
