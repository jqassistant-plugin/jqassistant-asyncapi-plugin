// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    @JsonProperty("openIdConnectUrl")
    private String openIdConnectUrl;

    @JsonProperty("scopes")
    private List<Object> scopes;
}
