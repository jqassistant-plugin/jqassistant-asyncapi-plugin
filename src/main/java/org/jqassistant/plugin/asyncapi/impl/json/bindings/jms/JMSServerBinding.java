// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.jms;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;

/**
 * This object contains information about the server representation in JMS.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JMSServerBinding extends ServerBinding {
    /**
     * REQUIRED. The classname of the ConnectionFactory implementation for the JMS Provider.
     */
    @JsonProperty("jmsConnectionFactory")
    private String jmsConnectionFactory;

    /**
     * OPTIONAL. Additional properties to set on the JMS ConnectionFactory implementation for the JMS Provider.
     */
    // FIXME: See https://github.com/asyncapi/bindings/issues/232
    @JsonProperty("properties")
    private List<Map<String, Object>> properties;

    /**
     * OPTIONAL. A client identifier for applications that use this JMS connection factory. If the Client ID Policy is
     * set to 'Restricted' (the default), then configuring a Client ID on the ConnectionFactory prevents more than one
     * JMS client from using a connection from this factory.
     */
    @JsonProperty("clientID")
    private String clientID;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @Builder.Default
    @JsonProperty("bindingVersion")
    private String bindingVersion = "0.0.1";
}
