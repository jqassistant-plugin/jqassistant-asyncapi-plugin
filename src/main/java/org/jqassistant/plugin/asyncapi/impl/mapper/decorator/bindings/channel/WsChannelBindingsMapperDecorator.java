package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.websockets.WsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.websockets.WebSocketChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.WsChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class WsChannelBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<WebSocketChannelBinding, WsChannelBindingsDescriptor>
        implements WsChannelBindingsMapper {

    protected WsChannelBindingsMapperDecorator(WsChannelBindingsMapper mapper) {
        super("ws", WsChannelBindingsDescriptor.class, mapper);
    }

    @Override
    public WsChannelBindingsDescriptor toDescriptor(WebSocketChannelBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}