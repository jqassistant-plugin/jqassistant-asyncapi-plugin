package org.jqassistant.plugin.asyncapi.impl.mapper;


import org.mapstruct.Mapping;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Mapping(target = "path", ignore = true)
@Mapping(target = "referenceableKey", ignore = true)
@Target(METHOD)
public @interface ReferenceableObjectMapping {
}
