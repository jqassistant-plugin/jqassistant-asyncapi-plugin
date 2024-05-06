package org.jqassistant.plugin.asyncapi.impl.mapper;

import org.mapstruct.MapperConfig;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

@MapperConfig(nullValueIterableMappingStrategy = RETURN_DEFAULT)
public interface DescriptorMapperConfig {
}
