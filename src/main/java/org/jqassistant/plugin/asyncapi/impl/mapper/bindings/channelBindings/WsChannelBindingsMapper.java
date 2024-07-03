package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.websockets.WsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.websockets.WebSocketChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel.WsChannelBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@DecoratedWith(WsChannelBindingsMapperDecorator.class)
public interface WsChannelBindingsMapper extends DescriptorMapper<WebSocketChannelBinding, WsChannelBindingsDescriptor> {

    WsChannelBindingsMapper INSTANCE = Mappers.getMapper(WsChannelBindingsMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    WsChannelBindingsDescriptor toDescriptor(WebSocketChannelBinding binding, @Context Scanner scanner);

}
