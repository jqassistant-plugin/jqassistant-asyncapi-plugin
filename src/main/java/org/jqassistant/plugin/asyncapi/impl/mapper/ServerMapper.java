package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ServerDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.Server;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.ServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ServerMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ListToStringMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = { ListToStringMapper.class, TagMapper.class, ExternalDocsMapper.class, ServerVariablesMapper.class, ServerBindingsMapper.class })
@DecoratedWith(ServerMapperDecorator.class)
public interface ServerMapper extends ReferenceableObjectMapper<Server, ServerDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "security", ignore = true)
    @Mapping(target = "path", ignore = true)

    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "security" })
    @Override
    ServerDescriptor toDescriptor(Server server, @Context Scanner scanner);

    @Override
    default List<ServerDescriptor> toDescriptors(Map<String, Server> servers, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ServerDescriptor> toDescriptors(List<Server> servers, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}
