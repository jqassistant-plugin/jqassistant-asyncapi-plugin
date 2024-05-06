package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import java.util.Stack;

public class MappingPath {

    private final Stack<String> path = new Stack<>();

    public void enter(String segment) {
        path.push(segment);
    }

    public void leave() {
        path.pop();
    }

    public boolean isEmpty() {
        return path.isEmpty();
    }

    public String getPath() {
        StringBuilder key = new StringBuilder().append('#');
        for (String s : path) {
            key.append('/')
                    .append(s);
        }
        return key.toString();
    }
}
