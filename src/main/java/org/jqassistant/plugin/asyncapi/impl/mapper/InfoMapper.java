package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.InfoDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.Info;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.InfoMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.URIMapper;
import org.mapstruct.*;

@Mapper(uses = { LicenseMapper.class, ContactMapper.class, URIMapper.class, TagMapper.class, ExternalDocsMapper.class })
@DecoratedWith(InfoMapperDecorator.class)
public interface InfoMapper extends DescriptorMapper<Info, InfoDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference"})
    @Override
    InfoDescriptor toDescriptor(Info info, @Context Scanner scanner);

}
