// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;

@Getter
@Setter
@ToString
public class OAuthFlows extends ReferenceObject {

    @JsonProperty("implicit")
    private OAuthFlow implicit;

    @JsonProperty("password")
    private OAuthFlow password;

    @JsonProperty("clientCredentials")
    private OAuthFlow clientCredentials;

    @JsonProperty("authorizationCode")
    private OAuthFlow authorizationCode;
}
