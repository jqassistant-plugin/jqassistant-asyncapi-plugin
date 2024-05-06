package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ListToStringMapper {

    default String map(List<String> list) {
        if (list != null) {
            return list.toString();
        }
        return null;
    }
}
