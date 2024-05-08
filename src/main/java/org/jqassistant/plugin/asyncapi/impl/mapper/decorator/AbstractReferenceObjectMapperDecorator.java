package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.MappingPath;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.PathMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;

public abstract class AbstractReferenceObjectMapperDecorator<T extends ReferenceObject, D extends AsyncApiDescriptor>
        implements ReferenceableObjectMapper<T, D>, TreeNodeMapper, PathMapper<D> {

    private final String elementName;

    private final DescriptorMapper<T, D> mapper;

    private final Class<D> descriptorType;

    protected AbstractReferenceObjectMapperDecorator(String elementName, Class<D> descriptorType, DescriptorMapper<T, D> mapper) {
        this.elementName = elementName;
        this.mapper = mapper;
        this.descriptorType = descriptorType;
    }

    /**
     * Only object is received and put through to create an appropriate descriptor
     **/
    @Override
    public D toDescriptor(T object, Scanner scanner) {
        enterTreeNode(elementName, scanner);
        D descriptor = this.basicToDescriptor(object, scanner);
        leaveTreeNode(scanner);
        return descriptor;
    }

    /**
     * Map of objects is received and put through to create a list of appropriate descriptors. The (String) keys are saved as name for later path mapping.
     **/
    @Override
    public List<D> toDescriptors(Map<String, T> values, Scanner scanner) {
        List<D> descriptors = new ArrayList<>();
        enterTreeNode(elementName, scanner);
        if (values != null) {
            for (Map.Entry<String, T> entry : values.entrySet()) {
                String name = entry.getKey();
                T value = entry.getValue();
                enterTreeNode(name, scanner);
                D descriptor = this.basicToDescriptor(value, scanner);
                if(descriptor != null){
                    descriptor.setName(entry.getKey());
                }
                descriptors.add(descriptor);
                leaveTreeNode(scanner);
            }
        }
        leaveTreeNode(scanner);
        return descriptors;
    }

    /**
     * List of objects is received and put through to create a list of appropriate descriptors. Saves the position of each element in the path.
     **/
    @Override
    public List<D> toDescriptors(List<T> values, Scanner scanner) {
        List<D> descriptors = new ArrayList<>();
        if (values != null) {
            int index = 0;
            for (T value : values) {
                enterTreeNode(elementName + "[" + index + "]", scanner);
                D descriptor = this.basicToDescriptor(value, scanner);
                descriptor.setPath(scanner.getContext()
                        .peek(MappingPath.class)
                        .getPath());
                leaveTreeNode(scanner);
                descriptors.add(descriptor);
                index++;
            }
        }
        return descriptors;
    }

    /**
     * Core Method to map each object to a descriptor. Takes the object, resolves the descriptor (reference or not) and sets the path.
     **/
    private D basicToDescriptor(T object, Scanner scanner) {
        D descriptor = resolveReference(object, scanner);
        if (descriptor != null) {
            return descriptor;
        }
        descriptor = mapper.toDescriptor(object, scanner);
        descriptor = PathMapper.super.setPath(descriptor, scanner);
        return descriptor;
    }

    /**
     * Reference Resolver: Checks if the given object is a reference. Case true, returns a ReferenceDescriptor and with the required descriptor type.
     **/
    private D resolveReference(T object, Scanner scanner) {
        if (object != null && object.getReference() != null) {
            ReferenceDescriptor referenceDescriptor = scanner.getContext()
                    .getStore()
                    .create(ReferenceDescriptor.class);
            referenceDescriptor.setReference(object.getReference());
            D descriptor = scanner.getContext()
                    .getStore()
                    .addDescriptorType(referenceDescriptor, descriptorType);
            descriptor = PathMapper.super.setPath(descriptor, scanner);
            return descriptor;
        }
        return null;
    }

}