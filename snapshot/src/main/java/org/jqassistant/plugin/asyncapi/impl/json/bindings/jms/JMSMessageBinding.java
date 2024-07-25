// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class JMSMessageBinding extends ReferenceObject {
    /**
     * OPTIONAL. A Schema object containing the definitions for JMS specific headers (so-called protocol headers).
     * This schema MUST be of type object and have a properties key. Examples of JMS protocol headers are JMSMessageID,
     * JMSTimestamp, and JMSCorrelationID.
     */
  /*  @JsonProperty(value = "headers")
    private SchemaObject headers;*/ // must be of type schema object

    @JsonProperty(value = "bindingVersion", defaultValue = "0.0.1")
    private String bindingVersion;
}
