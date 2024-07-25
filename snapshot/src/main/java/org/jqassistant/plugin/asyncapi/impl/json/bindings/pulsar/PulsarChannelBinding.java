// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * This object contains information about the channel representation in Pulsar.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/pulsar/README.md#channel-binding-object">Pulsar Channel</a>
 *
 */
@Getter
@Setter
@ToString
public class PulsarChannelBinding {

    @JsonProperty("namespace")
    private String namespace;

    @JsonProperty("persistence")
    private PulsarPesistenceType persistence;

    @JsonProperty("compaction")
    private Integer compaction;

    @JsonProperty("geo-replication")
    private List<String> georeplication;

    @JsonProperty("retention")
    private PulsarRetention retention;

    @JsonProperty("ttl")
    private Integer ttl;

    @JsonProperty("deduplication")
    private Boolean deduplication;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.1.0")
    private String bindingVersion;

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
