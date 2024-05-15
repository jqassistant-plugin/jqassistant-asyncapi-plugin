// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class KafkaChannelTopicConfiguration extends ReferenceObject {

    @JsonProperty("cleanup.policy")
    private List<String> cleanupPolicy;

    @JsonProperty("retention.ms")
    private Integer retentionMs;

    @JsonProperty("retention.bytes")
    private Integer retentionBytes;

    @JsonProperty("delete.retention.ms")
    private Integer deleteRetentionMs;

    @JsonProperty("max.message.bytes")
    private Integer maxMessageBytes;

    @JsonProperty("confluent.key.schema.validation")
    private Boolean confluentKeySchemaValidation;

    @JsonProperty("confluent.key.subject.name.strategy")
    private String confluentKeySubjectNameStrategy;

    @JsonProperty("confluent.value.schema.validation")
    private Boolean confluentValueSchemaValidation;

    @JsonProperty("confluent.value.subject.name.strategy")
    private String confluentValueSubjectNameStrategy;
}
