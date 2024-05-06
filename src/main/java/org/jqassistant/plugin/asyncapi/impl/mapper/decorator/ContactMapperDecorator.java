package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ContactDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.info.Contact;
import org.jqassistant.plugin.asyncapi.impl.mapper.ContactMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;
import org.mapstruct.Context;

public abstract class ContactMapperDecorator extends AbstractReferenceObjectMapperDecorator<Contact, ContactDescriptor>
        implements ContactMapper, TreeNodeMapper {

    public ContactMapperDecorator(ContactMapper mapper) {
        super("contact", mapper);
    }

    @Override
    public ContactDescriptor toDescriptor(Contact contact, @Context Scanner scanner) {
        return super.toDescriptor(contact, scanner);
    }

}