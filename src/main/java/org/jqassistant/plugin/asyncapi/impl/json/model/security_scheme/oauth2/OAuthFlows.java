// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.flows.AuthorizationCodeOAuthFlow;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.flows.ClientCredentialsOAuthFlow;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.flows.ImplicitOAuthFlow;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.flows.PasswordOAuthFlow;

@Getter
@Setter
@ToString
public class OAuthFlows extends ReferenceObject {

    @JsonProperty("implicit")
    private ImplicitOAuthFlow implicit;

    @JsonProperty("password")
    private PasswordOAuthFlow password;

    @JsonProperty("clientCredentials")
    private ClientCredentialsOAuthFlow clientCredentials;

    @JsonProperty("authorizationCode")
    private AuthorizationCodeOAuthFlow authorizationCode;
}
