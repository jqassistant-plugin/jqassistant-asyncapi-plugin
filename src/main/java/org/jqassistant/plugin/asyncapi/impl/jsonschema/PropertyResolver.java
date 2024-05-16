package org.jqassistant.plugin.asyncapi.impl.jsonschema;

import java.util.HashMap;
import java.util.Map;

import com.buschmais.jqassistant.core.store.api.Store;

import org.jqassistant.plugin.openapi.api.model.jsonschema.PropertyDescriptor;

class PropertyResolver {

    private final Map<String, PropertyDescriptor> propertyMap;
    private final Store store;

    public PropertyResolver(Store store) {
        this.propertyMap = new HashMap<>();
        this.store = store;
    }

    PropertyDescriptor resolve(String name){
        return propertyMap.computeIfAbsent(name, key -> {
            PropertyDescriptor propertyDescriptor = store.create(PropertyDescriptor.class);
            propertyDescriptor.setName(key);
            return propertyDescriptor;
        });
    }
}
