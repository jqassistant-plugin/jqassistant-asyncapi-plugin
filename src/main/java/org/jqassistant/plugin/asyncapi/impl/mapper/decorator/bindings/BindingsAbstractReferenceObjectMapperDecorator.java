package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.MappingPath;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.PathMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;

public abstract class BindingsAbstractReferenceObjectMapperDecorator<T extends ReferenceObject, D extends AsyncApiDescriptor>
        implements TreeNodeMapper, PathMapper<D> {

    private final String elementName;

    private final DescriptorMapper<T, D> mapper;

    protected BindingsAbstractReferenceObjectMapperDecorator(String elementName, DescriptorMapper<T, D> mapper) {
        this.elementName = elementName;
        this.mapper = mapper;
    }

    public D toDescriptor(T object, Scanner scanner) {
        enterTreeNode(elementName, scanner);
        D descriptor = mapper.toDescriptor(object, scanner);
        if (object != null && object.getReference() != null) {
            descriptor = PathMapper.super.setPath(descriptor, scanner);
        }
        if (descriptor != null) {
            descriptor.setPath(scanner.getContext()
                    .peek(MappingPath.class)
                    .getPath());
        }
        leaveTreeNode(scanner);
        return descriptor;
    }

}