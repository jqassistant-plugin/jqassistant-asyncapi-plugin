package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.ContactDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.Contact;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ContactMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.URIMapper;
import org.mapstruct.*;

@Mapper(uses = URIMapper.class)
@DecoratedWith(ContactMapperDecorator.class)
public interface ContactMapper extends DescriptorMapper<Contact, ContactDescriptor> {


    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ContactDescriptor toDescriptor(Contact contact, @Context Scanner scanner);

}
