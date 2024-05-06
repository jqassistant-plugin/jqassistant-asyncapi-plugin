package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public abstract class ReferenceMapper<T extends ReferenceObject, D extends Descriptor> {

    protected D resolveReference(T object, Class<D> descriptorType, Scanner scanner) {
        if (object.getReference() != null) {
            ReferenceDescriptor referenceDescriptor = scanner.getContext()
                    .getStore()
                    .create(ReferenceDescriptor.class);
            referenceDescriptor.setReference(object.getReference());
            return scanner.getContext()
                    .getStore()
                    .addDescriptorType(referenceDescriptor, descriptorType);
        }
        return null;
    }

}