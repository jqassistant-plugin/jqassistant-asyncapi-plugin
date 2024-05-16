// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.jms;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class JMSServerBinding extends ReferenceObject {

    @JsonProperty("jmsConnectionFactory")
    private String jmsConnectionFactory;

    // FIXME: See https://github.com/asyncapi/bindings/issues/232
    @JsonProperty("properties")
    private List<Map<String, Object>> properties;

    @JsonProperty("clientID")
    private String clientId;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.0.1")
    private String bindingVersion;
}
