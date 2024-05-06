// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.googlepubsub;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * The Message Storage Policy Object is used to describe the Google Cloud Pub/Sub MessageStoragePolicy Object
 * with AsyncAPI.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GooglePubSubMessageStoragePolicy {
    /**
     * A list of IDs of GCP regions where messages that are published to the topic may be persisted in storage
     */
    @JsonProperty("allowedPersistenceRegions")
    private List<String> allowedPersistenceRegions;
}
