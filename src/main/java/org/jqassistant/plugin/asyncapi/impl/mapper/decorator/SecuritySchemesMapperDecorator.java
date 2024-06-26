package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.SecuritySchemeDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;
import org.jqassistant.plugin.asyncapi.impl.mapper.SecuritySchemesMapper;
import org.mapstruct.Context;

public abstract class SecuritySchemesMapperDecorator extends AbstractReferenceObjectMapperDecorator<SecurityScheme, SecuritySchemeDescriptor>
        implements SecuritySchemesMapper {

    protected SecuritySchemesMapperDecorator(SecuritySchemesMapper mapper) {
        super("securitySchemes", SecuritySchemeDescriptor.class, mapper);
    }

    @Override
    public SecuritySchemeDescriptor toDescriptor(SecurityScheme securityScheme, @Context Scanner scanner) {
        return super.toDescriptor(securityScheme, scanner);
    }

    @Override
    public List<SecuritySchemeDescriptor> toDescriptors(Map<String, SecurityScheme> securityScheme, @Context Scanner scanner) {
        return super.toDescriptors(securityScheme, scanner);
    }
}