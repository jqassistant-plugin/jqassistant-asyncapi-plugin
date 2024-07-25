// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sqs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SQSChannelBindingPolicy {

    /**
     * Required. An array of Statement objects, each of which controls a permission for this queue.
     */
    @JsonProperty("statements")
    private List<SQSChannelBindingStatement> statements;
}
