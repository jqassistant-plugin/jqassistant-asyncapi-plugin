package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.TagDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.mapper.TagMapper;
import org.mapstruct.Context;

public abstract class TagMapperDecorator extends AbstractReferenceObjectMapperDecorator<Tag, TagDescriptor> implements TagMapper {

    protected TagMapperDecorator(TagMapper mapper) {
        super("tags", TagDescriptor.class, mapper);
    }

    @Override
    public TagDescriptor toDescriptor(Tag tag, @Context Scanner scanner) {
        return super.toDescriptor(tag, scanner);
    }

    @Override
    public List<TagDescriptor> toDescriptors(Map<String, Tag> tags, @Context Scanner scanner) {
        return super.toDescriptors(tags, scanner);
    }
}