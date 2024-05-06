package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ChannelBindingsMapper extends DescriptorMapper<ChannelBinding, ChannelBindingsDescriptor> {
    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ChannelBindingsDescriptor toDescriptor(ChannelBinding channelBinding, @Context Scanner scanner);

    default List<ChannelBindingsDescriptor> toDescriptor(Map<String, ChannelBinding> bindings, @Context Scanner scanner) {
        if (bindings != null) {
            List<ChannelBindingsDescriptor> allBindings = new LinkedList<>();
            for (String protocol : bindings.keySet()) {
                switch (protocol) {

                case "aqmp":

                case "aqmp1":

                case "googlepubsub":

                case "jms":

                case "kafka":
                    allBindings.add(KafkaChannelBindingsMapper.INSTANCE.toDescriptor(bindings.get(protocol), scanner));

                case "mercure":

                case "mqtt":

                case "nats":

                case "pulsar":

                case "redis":

                case "sns":

                case "sqs":

                case "stomp":

                case "websockets":

                }
            }
            return allBindings;
        }
        return null;
    }

}