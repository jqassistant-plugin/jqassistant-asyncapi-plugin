// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.pulsar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;

/**
 * This object contains information about the server representation in Pulsar.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/pulsar/README.md#server-binding-object">Pulsar Server</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarServerBinding extends ServerBinding {
    /**
     * The pulsar tenant. If omitted, "public" MUST be assumed.
     * </p>
     * Default: public
     */
    @Builder.Default
    @JsonProperty("tenant")
    private String tenant = "public";

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.1.0";
}
