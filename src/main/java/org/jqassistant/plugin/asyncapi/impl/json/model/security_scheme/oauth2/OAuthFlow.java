// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class OAuthFlow extends ReferenceObject {

    @JsonProperty("refreshUrl")
    private String refreshUrl;

    @JsonProperty("availableScopes")
    private Map<String, String> availableScopes;

    @JsonProperty("authorizationUrl")
    private String authorizationUrl;

    @JsonProperty("tokenUrl")
    private String tokenUrl;
}
