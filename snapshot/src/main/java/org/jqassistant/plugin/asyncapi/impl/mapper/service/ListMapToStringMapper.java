package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;

@Mapper
public interface ListMapToStringMapper {

    default String map(List<Map<String, Object>> list) {
        if (list != null) {
            return list.toString();
        }
        return null;
    }
}
