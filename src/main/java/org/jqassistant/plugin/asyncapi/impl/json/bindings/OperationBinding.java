// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public class OperationBinding extends ReferenceObject {

    @JsonProperty("kafka")
    private KafkaOperationBinding kafkaOperationBinding;

}
