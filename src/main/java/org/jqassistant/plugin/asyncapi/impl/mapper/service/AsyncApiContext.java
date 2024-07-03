package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import lombok.Getter;
import lombok.Setter;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Setter
@Getter
public class AsyncApiContext {

    private Map<String, ReferenceableDescriptor> referenceables = new HashMap<>();
    private Map<String, ReferenceDescriptor> references = new HashMap<>();
    private final Stack<String> path = new Stack<>();

    public void addReferenceable(String path, ReferenceableDescriptor referenceable) {
        referenceables.put(path, referenceable);
    }

    public void addReference(String path, ReferenceDescriptor reference) {
        references.put(path, reference);
    }


    //Mapping Methods
    public void enter(String segment) {
        path.push(segment);
    }

    public void leave() {
        path.pop();
    }

    public boolean isEmpty() {
        return path.isEmpty();
    }

    public String getPath() {
        StringBuilder key = new StringBuilder().append('#');
        for (String s : path) {
            key.append('/')
                    .append(s);
        }
        return key.toString();
    }
}
