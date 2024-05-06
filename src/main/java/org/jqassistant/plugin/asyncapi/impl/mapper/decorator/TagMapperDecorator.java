package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.TagDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.Tag;
import org.jqassistant.plugin.asyncapi.impl.mapper.TagMapper;
import org.mapstruct.Context;

public abstract class TagMapperDecorator extends AbstractReferenceObjectMapperDecorator<Tag, TagDescriptor> implements TagMapper {

    public TagMapperDecorator(TagMapper mapper) {
        super("tags", mapper);
    }

    /**
     * Procedure for InfoDescriptor not entirely correct: should actually reference the position of
     * the tag in the list; Use case not yet encountered, so simplified representation here.
     **/
    @Override
    public TagDescriptor toDescriptor(Tag tag, @Context Scanner scanner) {
        return super.toDescriptor(tag, scanner);
    }

    @Override
    public List<TagDescriptor> toDescriptors(Map<String, Tag> tags, @Context Scanner scanner) {
        return super.toDescriptors(tags, scanner);
    }
}