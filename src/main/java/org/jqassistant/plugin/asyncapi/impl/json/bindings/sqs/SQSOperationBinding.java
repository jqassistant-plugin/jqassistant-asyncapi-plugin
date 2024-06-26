// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sqs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

/**
 * SQS Point-To-Point
 * </p>
 * Because we have defined Queue as part of the Channel Binding Binding object, we do not require Binding information
 * for the publish Operation Object of the subscribe Operation Object. You can use an empty Queue object ({}) to denote
 * the Binding on the Operation Object, if you want to indicate the protocol used to send or receive for generation
 * purposes such as Infrastructure As Code.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/sqs/README.md#operation-binding-object">SQS Operation</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SQSOperationBinding extends ReferenceObject {
    /**
     * Required. Queue objects that are either the endpoint for an SNS Operation Binding Object, or the deadLetterQueue
     * of the SQS Operation Binding Object
     */
    @JsonProperty("queues")
    private List<SQSChannelBindingQueue> queues;

    /**
     * Optional, defaults to latest. The version of this binding.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.2.0";
}
