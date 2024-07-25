package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import org.mapstruct.Mapper;

import java.net.URI;

@Mapper
public interface URIMapper {

    default String map(URI uri) {
        if (uri != null) {
            return uri.toString();
        } else {
            return null;
        }
    }

}
