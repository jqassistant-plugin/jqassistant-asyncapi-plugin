// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.nats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;

/**
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/nats/README.md#operation-binding-object">NATS Operation</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NATSOperationBinding extends OperationBinding {
    /**
     * Defines the name of the queue to use. It MUST NOT exceed 255 characters.
     */
    @JsonProperty("queue")
    private String queue;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.1.0";
}
