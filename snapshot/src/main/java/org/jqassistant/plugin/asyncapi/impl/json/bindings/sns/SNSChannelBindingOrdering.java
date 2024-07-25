// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sns;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSChannelBindingOrdering {
    /**
     * Required. Defines the type of SNS Topic. Can be either standard or FIFO.
     */
    @JsonProperty("type")
    private SNSChannelBindingOrderingType type;

    /**
     * Optional. Whether the de-duplication of messages should be turned on. Defaults to false
     */
    @Builder.Default
    @JsonProperty("contentBasedDeduplication")
    private Boolean contentBasedDeduplication = false;
}
