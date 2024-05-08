package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ExternalDocsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.mapper.ExternalDocsMapper;
import org.mapstruct.Context;

public abstract class ExternalDocsMapperDecorator extends AbstractReferenceObjectMapperDecorator<ExternalDocumentation, ExternalDocsDescriptor>
        implements ExternalDocsMapper {

    public ExternalDocsMapperDecorator(ExternalDocsMapper mapper) {
        super("externalDocs", ExternalDocsDescriptor.class, mapper);
    }

    @Override
    public ExternalDocsDescriptor toDescriptor(ExternalDocumentation externalDocs, @Context Scanner scanner) {
        return super.toDescriptor(externalDocs, scanner);
    }

    @Override
    public List<ExternalDocsDescriptor> toDescriptors(List<ExternalDocumentation> values, @Context Scanner scanner) {
        return super.toDescriptors(values, scanner);
    }

    @Override
    public List<ExternalDocsDescriptor> toDescriptors(Map<String, ExternalDocumentation> values, @Context Scanner scanner) {
        return super.toDescriptors(values, scanner);
    }
}