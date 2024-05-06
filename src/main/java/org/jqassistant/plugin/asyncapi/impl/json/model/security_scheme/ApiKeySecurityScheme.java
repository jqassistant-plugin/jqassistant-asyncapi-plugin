// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiKeySecurityScheme extends SecurityScheme {

    @JsonProperty("in")
    private ApiKeyLocation in;

    public enum ApiKeyLocation {
        USER("user"),
        PASSWORD("password");

        public final String type;

        ApiKeyLocation(String type) {
            this.type = type;
        }

        public static ApiKeyLocation fromString(String type) {
            return valueOf(type.toUpperCase());
        }

        @Override
        public String toString() {
            return this.type;
        }
    }
}
