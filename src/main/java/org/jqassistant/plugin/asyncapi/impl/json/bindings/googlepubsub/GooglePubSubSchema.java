// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.googlepubsub;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Schema Definition Object is used to describe the Google Cloud Pub/Sub Schema Object with AsyncAPI. While some
 * of this information could be, or is, described using native AsyncAPI, for consistency it makes sense to provide this
 * information here at all times, especially for cases where AsyncAPI does not natively support describing payloads
 * using a supported Google Cloud Pub/Sub schema format like Protobuf.
 */

public class GooglePubSubSchema {
    /**
     * The name of the schema
     */
    @JsonProperty("name")
    private String name;
}
