package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.mapstruct.Context;

public interface TreeNodeMapper {

    default void enterTreeNode(String name, @Context Scanner scanner) {
        scanner.getContext()
                .peek(AsyncApiContext.class)
                .enter(name);
    }

    default void leaveTreeNode(@Context Scanner scanner) {
        scanner.getContext()
                .peek(AsyncApiContext.class)
                .leave();
    }

}
