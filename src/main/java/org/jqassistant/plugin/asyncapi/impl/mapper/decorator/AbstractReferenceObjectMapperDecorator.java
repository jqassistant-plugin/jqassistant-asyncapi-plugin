package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.AsyncApiContext;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractReferenceObjectMapperDecorator<T extends ReferenceObject, D extends ReferenceableDescriptor>
        implements ReferenceableObjectMapper<T, D>, TreeNodeMapper {

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
                if (descriptor != null) {
                    descriptor.setReferenceableKey(entry.getKey());
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
                if (descriptor != null) {
                    descriptor.setPath(scanner.getContext()
                            .peek(AsyncApiContext.class)
                            .getPath());
                }
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
        D descriptor;
        boolean isReference = false;
        if (object != null && object.getReference() != null) {
            descriptor = resolveReference(object.getReference(), scanner);
            isReference = true;
        } else {
            descriptor = mapper.toDescriptor(object, scanner);
        }
        if (descriptor != null) {
            AsyncApiContext context = scanner.getContext().peek(AsyncApiContext.class);
            descriptor.setPath(context.getPath());
            context.addReferenceable(context.getPath(), descriptor);
            if (isReference) {
                context.addReference(context.getPath(), (ReferenceDescriptor) descriptor);
            }
        }
        return descriptor;
    }

    /**
     * retrieves an ReferenceDescriptor with the given reference
     **/
    private D resolveReference(String reference, Scanner scanner) {
        ReferenceDescriptor referenceDescriptor = scanner.getContext()
                .getStore()
                .create(ReferenceDescriptor.class);
        referenceDescriptor.setReference(reference);
        return scanner.getContext()
                .getStore()
                .addDescriptorType(referenceDescriptor, descriptorType);
    }

}