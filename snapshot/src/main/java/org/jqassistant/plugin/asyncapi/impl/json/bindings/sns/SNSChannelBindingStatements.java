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
public class SNSChannelBindingStatements {
    /**
     * Required. Either "Allow" or "Deny"
     */
    @JsonProperty("effect")
    private SNSChannelBindingEffect effect;

    /**
     * Required. The AWS account or resource ARN that this statement applies to
     */
    @JsonProperty("principal")
    private String principal;

    /**
     * Required. The SNS permission being allowed or denied e.g. sns:Publish
     */
    @JsonProperty("action")
    private String action;
}
