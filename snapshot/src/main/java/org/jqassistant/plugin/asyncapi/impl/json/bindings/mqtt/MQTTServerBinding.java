// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.mqtt;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

public class MQTTServerBinding extends ReferenceObject {

    @JsonProperty("clientId")
    private String clientId;

    @JsonProperty("cleanSession")
    private Boolean cleanSession;

    @JsonProperty("lastWill")
    private MQTTServerLastWill lastWill;

    @JsonProperty("keepAlive")
    private Integer keepAlive;

    /**
     * Interval in seconds or a Schema Object containing the definition of the interval. The broker maintains a session
     * for a disconnected client until this interval expires.
     */
    @JsonProperty("sessionExpiryInterval")
    private Object sessionExpiryInterval;

    /**
     * Number of bytes or a Schema Object representing the maximum packet size the client is willing to accept.
     */
    @JsonProperty("maximumPacketSize")
    private Object maximumPacketSize;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.2.0")
    private String bindingVersion;

}
