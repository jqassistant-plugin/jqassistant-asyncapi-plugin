package org.jqassistant.plugin.asyncapi.impl;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.scanner.api.ScannerPlugin.Requires;
import com.buschmais.jqassistant.core.scanner.api.Scope;
import com.buschmais.jqassistant.core.store.api.Store;
import com.buschmais.jqassistant.plugin.common.api.model.FileDescriptor;
import com.buschmais.jqassistant.plugin.common.api.scanner.AbstractScannerPlugin;
import com.buschmais.jqassistant.plugin.common.api.scanner.filesystem.FileResource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.AsyncAPI;
import org.jqassistant.plugin.asyncapi.impl.mapper.AsyncApiMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.MappingPath;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

@Requires(FileDescriptor.class)
public class AsyncAPIScannerPlugin extends AbstractScannerPlugin<FileResource, ContractDescriptor> {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncAPIScannerPlugin.class);

    private ObjectMapper mapper;

    @Override
    public void initialize() {
        this.mapper = new YAMLMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public boolean accepts(FileResource fileResource, String path, Scope scope) {
        return AsyncApiScope.CONTRACT.equals(scope) &&
                (path.toLowerCase().endsWith(".yml") || path.toLowerCase().endsWith(".yaml"));
    }

    @Override
    public ContractDescriptor scan(FileResource fileResource, String path, Scope scope, Scanner scanner) throws IOException {
        LOG.info("Starting scanning process for {}", path);
        final Store store = scanner.getContext().getStore();
        final FileDescriptor fileDescriptor = scanner.getContext().getCurrentDescriptor();
        final ContractDescriptor contractDescriptor = store.addDescriptorType(fileDescriptor, ContractDescriptor.class);

        try (InputStream inputStream = fileResource.createStream()) {
            AsyncAPI asyncApi = mapper.readValue(inputStream, AsyncAPI.class);
            scanner.getContext().push(ContractDescriptor.class, contractDescriptor);
            scanner.getContext().push(MappingPath.class, new MappingPath());
            try {
                Mappers.getMapper(AsyncApiMapper.class).toDescriptor(asyncApi, contractDescriptor, scanner);
            } finally {
                scanner.getContext().pop(MappingPath.class);
            }
        }
        return contractDescriptor;
    }
}
