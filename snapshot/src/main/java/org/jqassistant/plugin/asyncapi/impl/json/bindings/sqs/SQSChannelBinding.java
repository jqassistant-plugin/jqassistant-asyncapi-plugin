// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sqs;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SQSChannelBinding {

    @JsonProperty("queue")
    private SQSChannelBindingQueue queue;

    @JsonProperty("deadLetterQueue")
    private SQSChannelBindingQueue deadLetterQueue;

    @JsonProperty(value = "bindingVersion", defaultValue = "0.2.0" )
    private String bindingVersion;
}
