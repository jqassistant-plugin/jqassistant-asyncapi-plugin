// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpApiKeySecurityScheme extends SecurityScheme {

    @JsonProperty("name")
    private String name;

    @JsonProperty("in")
    private HttpApiKeyLocation in;

    public enum HttpApiKeyLocation {
        QUERY("query"),
        HEADER("header"),
        COOKIE("cookie");

        public final String type;

        HttpApiKeyLocation(String type) {
            this.type = type;
        }

        public static HttpApiKeyLocation fromString(String type) {
            return valueOf(type.toUpperCase());
        }

        @Override
        public String toString() {
            return this.type;
        }
    }
}
