package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;

public interface ReferenceMapper<D extends AsyncApiDescriptor> {

    default D setReference(D descriptor, Scanner scanner) {
        if (descriptor != null) {
            MappingPath mappingPath = scanner.getContext()
                    .peek(MappingPath.class);
            descriptor.setPath(mappingPath.getPath());
        }
        return descriptor;
    }
}
