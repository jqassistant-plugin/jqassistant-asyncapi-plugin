package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import lombok.Getter;
import lombok.Setter;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class AsyncApiContext {

    private Map<String, ReferenceableDescriptor> referenceables = new HashMap<>();
    private Map<String, ReferenceDescriptor> references = new HashMap<>();

    public void addReferenceable(String path, ReferenceableDescriptor referenceable) {
        referenceables.put(path, referenceable);
    }

    public void addReference(String path, ReferenceDescriptor reference) {
        references.put(path, reference);
    }
}
