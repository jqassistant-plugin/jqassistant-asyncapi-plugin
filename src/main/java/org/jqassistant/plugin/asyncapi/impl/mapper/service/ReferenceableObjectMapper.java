package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public interface ReferenceableObjectMapper<T extends ReferenceObject, D extends Descriptor> extends DescriptorMapper<T, D> {

    List<D> toDescriptors(Map<String, T> values, Scanner scanner);

    List<D> toDescriptors(List<T> values, Scanner scanner);

}
