// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.flows;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientCredentialsOAuthFlow extends OAuthFlow {

    @JsonProperty("tokenUrl")
    private String tokenUrl;

}
