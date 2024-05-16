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
public class JMSChannelBinding extends ReferenceObject {

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("destinationType")
    private String destinationType; //should be enum

    @JsonProperty(value = "bindingVersion", defaultValue = "0.0.1")
    private String bindingVersion;
}
