// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This objects contains information about the API relevant topic configuration in Kafka.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/kafka/README.md#topicConfiguration">Kafka Topic Configuration</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaChannelTopicConfiguration {
    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_cleanup.policy">cleanup.policy</a>
     * configuration option.
     */
    @JsonProperty("cleanup.policy")
    private List<KafkaChannelTopicCleanupPolicy> cleanupPolicy;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.ms">retention.ms</a>
     * configuration option.
     */
    @JsonProperty("retention.ms")
    private Integer retentionMs;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.bytes">retention.bytes</a>
     * configuration option.
     */

    @JsonProperty("retention.bytes")
    private Integer retentionBytes;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_delete.retention.ms">delete.retention.ms</a>
     * configuration option.
     */
    @JsonProperty("delete.retention.ms")
    private Integer deleteRetentionMs;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_max.message.bytes">max.message.bytes</a>
     * configuration option.
     */
    @JsonProperty("max.message.bytes")
    private Integer maxMessageBytes;

    /**
     * It shows whether the schema validation for the message key is enabled. Vendor specific config.
     */
    @JsonProperty("confluent.key.schema.validation")
    private Boolean confluentKeySchemaValidation;

    /**
     * The name of the schema lookup strategy for the message key. Vendor specific config.
     */
    @JsonProperty("confluent.key.subject.name.strategy")
    private String confluentKeySubjectNameStrategy;

    /**
     * It shows whether the schema validation for the message value is enabled. Vendor specific config.
     */
    @JsonProperty("confluent.value.schema.validation")
    private Boolean confluentValueSchemaValidation;

    /**
     * The name of the schema lookup strategy for the message value. Vendor specific config.
     */
    @JsonProperty("confluent.value.subject.name.strategy")
    private String confluentValueSubjectNameStrategy;
}
