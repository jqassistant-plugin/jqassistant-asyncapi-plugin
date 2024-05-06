package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.LicenseDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.License;
import org.jqassistant.plugin.asyncapi.impl.mapper.LicenseMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;
import org.mapstruct.Context;

public abstract class LicenseMapperDecorator extends AbstractReferenceObjectMapperDecorator<License, LicenseDescriptor>
        implements LicenseMapper, TreeNodeMapper {

    public LicenseMapperDecorator(LicenseMapper mapper) {
        super("license", mapper);
    }

    @Override
    public LicenseDescriptor toDescriptor(License license, @Context Scanner scanner) {
        return super.toDescriptor(license, scanner);
    }

}