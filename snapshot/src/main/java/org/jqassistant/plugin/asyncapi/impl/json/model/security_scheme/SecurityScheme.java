// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jqassistant.plugin.asyncapi.impl.json.model.ReferenceObject;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlows;

@Getter
@Setter
@ToString
public class SecurityScheme extends ReferenceObject {

    @JsonProperty("type")
    private String type;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty("name")
    private String name;

    @JsonProperty("in")
    private String in;

    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("bearerFormat")
    private String bearerFormat;

    @JsonProperty("flows")
    private OAuthFlows flows;

    @JsonProperty("openIdConnectUrl")
    private String openIdConnectUrl;

    @JsonProperty("scopes")
    private String scopes; //actually an array

}
