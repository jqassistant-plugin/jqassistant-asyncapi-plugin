package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OperationBindingsMapper extends DescriptorMapper<OperationBinding, OperationBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    OperationBindingsDescriptor toDescriptor(OperationBinding channelBinding, @Context Scanner scanner);

    default List<OperationBindingsDescriptor> toDescriptor(Map<String, OperationBinding> bindings, @Context Scanner scanner) {
        if (bindings != null) {
            List<OperationBindingsDescriptor> allBindings = new LinkedList<>();
            for (String protocol : bindings.keySet()) {
                switch (protocol) {

                case "http":

                case "ws":

                case "anypointmq":

                case "aqmp":

                case "aqmp1":

                case "mqtt":

                case "mqtt5":

                case "nats":

                case "jms":

                case "kafka":
                    allBindings.add(KafkaOperationBindingsMapper.INSTANCE.toDescriptor(bindings.get(protocol), scanner));

                case "sns":

                case "solace":

                case "sqs":

                case "stomp":

                case "redis":

                case "mercure":

                case "googlepubsub":

                case "ibmmq":

                case "pulsar":

                }
            }
            return allBindings;
        }
        return null;
    }
}