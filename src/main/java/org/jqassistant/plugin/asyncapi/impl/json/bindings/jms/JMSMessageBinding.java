// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.jms;

import javax.xml.validation.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBinding;

/**
 * This object contains information about the message representation in JMS.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/jms/README.md#message-binding-object">JMS Message</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JMSMessageBinding extends MessageBinding {
    /**
     * OPTIONAL. A Schema object containing the definitions for JMS specific headers (so-called protocol headers).
     * This schema MUST be of type object and have a properties key. Examples of JMS protocol headers are JMSMessageID,
     * JMSTimestamp, and JMSCorrelationID.
     */
    @JsonProperty(value = "headers")
    private Schema headers;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.0.1";
}
