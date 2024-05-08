package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ServerDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.Server;
import org.jqassistant.plugin.asyncapi.impl.mapper.ServerMapper;
import org.mapstruct.Context;

public abstract class ServerMapperDecorator extends AbstractReferenceObjectMapperDecorator<Server, ServerDescriptor> implements ServerMapper {

    public ServerMapperDecorator(ServerMapper mapper) {
        super("servers", ServerDescriptor.class, mapper);
    }

    @Override
    public ServerDescriptor toDescriptor(Server server, @Context Scanner scanner) {
        return super.toDescriptor(server, scanner);
    }

    @Override
    public List<ServerDescriptor> toDescriptors(Map<String, Server> servers, @Context Scanner scanner) {
        return super.toDescriptors(servers, scanner);
    }

    @Override
    public List<ServerDescriptor> toDescriptors(List<Server> servers, @Context Scanner scanner) {
        return super.toDescriptors(servers, scanner);
    }
}