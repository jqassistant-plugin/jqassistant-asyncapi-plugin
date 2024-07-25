// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpSecurityScheme extends SecurityScheme {

    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("bearerFormat")
    private String bearerFormat;

}
