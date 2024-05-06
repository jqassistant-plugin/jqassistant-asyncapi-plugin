// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;

/**
 * This object contains information about the channel representation in Pulsar.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/pulsar/README.md#channel-binding-object">Pulsar Channel</a>
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarChannelBinding extends ChannelBinding {

    /**
     * Required. The namespace the channel is associated with.
     */
    @JsonProperty("namespace")
    private String namespace;

    /**
     * Required. Persistence of the topic in Pulsar. It MUST be either persistent or non-persistent.
     */
    @JsonProperty("persistence")
    private PulsarPesistenceType persistence;

    /**
     * Topic compaction threshold given in Megabytes.
     */
    @JsonProperty("compaction")
    private Integer compaction;

    /**
     * A list of clusters the topic is replicated to.
     */
    @JsonProperty("geo-replication")
    private List<String> georeplication;

    /**
     * Topic retention policy.
     */
    @JsonProperty("retention")
    private PulsarRetention retention;

    /**
     * Message time-to-live in seconds.
     */
    @JsonProperty("ttl")
    private Integer ttl;

    /**
     * Message deduplication. When true, it ensures that each message produced on Pulsar topics is persisted to disk
     * only once.
     */
    @JsonProperty("deduplication")
    private Boolean deduplication;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.1.0";

    public enum PulsarPesistenceType {
        PERSISTENCE("persistent"),
        NON_PERSISTENCE("non-persistent");

        public final String type;

        PulsarPesistenceType(String type) {
            this.type = type;
        }

        public static PulsarPesistenceType fromString(String type) {
            return valueOf(type.toUpperCase());
        }

        @Override
        public String toString() {
            return this.type;
        }
    }
}
