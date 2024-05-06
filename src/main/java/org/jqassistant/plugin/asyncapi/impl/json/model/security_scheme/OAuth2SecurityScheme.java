// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlows;

@Getter
@Setter
@ToString
public class OAuth2SecurityScheme extends SecurityScheme {

    @JsonProperty("flows")
    private OAuthFlows flows;


    @JsonProperty("scopes")
    private List<String> scopes;

}
