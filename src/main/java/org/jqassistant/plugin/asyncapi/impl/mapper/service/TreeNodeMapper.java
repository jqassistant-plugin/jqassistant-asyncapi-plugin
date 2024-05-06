package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.mapstruct.Context;

public interface TreeNodeMapper {

    default void enterTreeNode(String name, @Context Scanner scanner) {
        scanner.getContext()
                .peek(MappingPath.class)
                .enter(name);
    }

    default void leaveTreeNode(@Context Scanner scanner) {
        scanner.getContext()
                .peek(MappingPath.class)
                .leave();
    }

}
