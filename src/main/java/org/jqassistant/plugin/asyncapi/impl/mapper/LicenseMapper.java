package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.LicenseDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.License;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.LicenseMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.URIMapper;
import org.mapstruct.*;

@Mapper(uses = URIMapper.class)
@DecoratedWith(LicenseMapperDecorator.class)

public interface LicenseMapper extends DescriptorMapper<License, LicenseDescriptor> {
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    LicenseDescriptor toDescriptor(License license, @Context Scanner scanner);

}
