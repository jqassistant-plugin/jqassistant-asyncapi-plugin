package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.KafkaChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class ChannelBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<ChannelBinding, ChannelBindingsDescriptor> implements ChannelBindingsMapper {

    public ChannelBindingsMapperDecorator(ChannelBindingsMapper mapper) {
        super("bindings", ChannelBindingsDescriptor.class, mapper);
    }

    @Override
    public ChannelBindingsDescriptor toDescriptor(ChannelBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

    @Override
    public List<ChannelBindingsDescriptor> toDescriptors(Map<String, ChannelBinding> bindings, @Context Scanner scanner) {
        if (bindings != null) {
            List<ChannelBindingsDescriptor> allBindings = new LinkedList<>();
            for (String protocol : bindings.keySet()) {
                switch (protocol) {

                case "aqmp":

                case "aqmp1":

                case "googlepubsub":

                case "jms":

                case "kafka":
                    KafkaChannelBinding b = (KafkaChannelBinding) bindings.get(protocol);
                    allBindings.add(KafkaChannelBindingsMapper.INSTANCE.toDescriptor(b, scanner));

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

    @Override
    public List<ChannelBindingsDescriptor> toDescriptors(List<ChannelBinding> bindings, @Context Scanner scanner) {
        return super.toDescriptors(bindings, scanner);
    }
}