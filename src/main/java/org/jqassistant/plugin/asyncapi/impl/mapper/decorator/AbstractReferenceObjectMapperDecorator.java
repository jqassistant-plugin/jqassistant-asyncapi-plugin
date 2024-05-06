package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.MappingPath;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferencesMapper;

public abstract class AbstractReferenceObjectMapperDecorator<T extends ReferenceObject, D extends AsyncApiDescriptor>
        implements ReferenceableObjectMapper<T, D>, TreeNodeMapper, ReferencesMapper<D> {

    private final String elementName;

    private final DescriptorMapper<T, D> mapper;

    protected AbstractReferenceObjectMapperDecorator(String elementName, DescriptorMapper<T, D> mapper) {
        this.elementName = elementName;
        this.mapper = mapper;
    }

    @Override
    public D toDescriptor(T object, Scanner scanner) {
        enterTreeNode(elementName, scanner);
        D descriptor = mapper.toDescriptor(object, scanner);
        if(object != null && object.getReference() != null){
            descriptor = ReferencesMapper.super.setReference(descriptor, scanner);
        }
        if(descriptor != null) {
            descriptor.setPath(scanner.getContext()
                    .peek(MappingPath.class)
                    .getPath());
        }
        leaveTreeNode(scanner);
        return descriptor;
    }

    @Override
    public List<D> toDescriptors(Map<String, T> values, Scanner scanner) {
        List<D> descriptors = new ArrayList<>();
        enterTreeNode(elementName, scanner);
        if(values != null) {
            for (Map.Entry<String, T> entry : values.entrySet()) {
                String name = entry.getKey();
                T value = entry.getValue();
                enterTreeNode(name, scanner);
                D descriptor = mapper.toDescriptor(value, scanner);
                descriptor.setPath(scanner.getContext().peek(MappingPath.class).getPath());
                descriptors.add(descriptor);
                leaveTreeNode(scanner);
            }
        }
        leaveTreeNode(scanner);
        return descriptors;
    }

    @Override
    public List<D> toDescriptors(List<T> values, Scanner scanner) {
        List<D> descriptors = new ArrayList<>();
        if(values != null) {
            int slot = 0;
            for (T value : values) {
                descriptors.add(this.listToDescriptor(value, slot, scanner));
                slot++;
            }
        }
        return descriptors;
    }

    public D listToDescriptor(T object, int slot, Scanner scanner) {
        enterTreeNode(elementName+"["+slot+"]", scanner);
        D descriptor = mapper.toDescriptor(object, scanner);
        descriptor.setPath(scanner.getContext().peek(MappingPath.class).getPath());
        leaveTreeNode(scanner);
        return descriptor;
    }

}