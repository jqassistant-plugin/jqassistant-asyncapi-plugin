package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;

public class ReferenceResolver {

    private final Map<String, ReferenceDescriptor> refMap;

    public ReferenceResolver() {
        this.refMap = new LinkedHashMap<>();
    }

    public <D extends Descriptor> D resolve(String reference, Class<D> descriptorType, Scanner scanner) {
        ReferenceDescriptor referenceDescriptor1 = refMap.computeIfAbsent(reference, ref -> scanner.getContext()
                .getStore()
                .create(ReferenceDescriptor.class, referenceDescriptor -> referenceDescriptor.setReference(ref)));
        return scanner.getContext()
                .getStore()
                .addDescriptorType(referenceDescriptor1, descriptorType);
    }
}




