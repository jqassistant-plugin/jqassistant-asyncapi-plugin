package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.TagDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.TagMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ExternalDocsMapper.class })
@DecoratedWith(TagMapperDecorator.class)
public interface TagMapper extends ReferenceableObjectMapper<Tag, TagDescriptor> {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    TagDescriptor toDescriptor(Tag tag, @Context Scanner scanner);

    @Override
    default List<TagDescriptor> toDescriptors(Map<String, Tag> tags, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<TagDescriptor> toDescriptors(List<Tag> tags, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}

