package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.InfoDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.Info;
import org.jqassistant.plugin.asyncapi.impl.mapper.InfoMapper;
import org.mapstruct.Context;

public abstract class InfoMapperDecorator extends AbstractReferenceObjectMapperDecorator<Info, InfoDescriptor> implements InfoMapper {

    protected InfoMapperDecorator(InfoMapper mapper) {
        super("info", InfoDescriptor.class, mapper);
    }

    @Override
    public InfoDescriptor toDescriptor(Info info, @Context Scanner scanner) {
        return super.toDescriptor(info, scanner);
    }

}