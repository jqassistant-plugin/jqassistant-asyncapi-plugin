package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;

public interface PathMapper<D extends AsyncApiDescriptor> {

    default D setPath(D descriptor, Scanner scanner) {
        if (descriptor != null) {
            MappingPath mappingPath = scanner.getContext()
                    .peek(MappingPath.class);
            descriptor.setPath(mappingPath.getPath());
        }
        return descriptor;
    }
}
