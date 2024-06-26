// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.model.schema;

import org.jqassistant.plugin.asyncapi.impl.json.model.AsyncAPI;

public enum SchemaFormat {
    /**
     * This is the default when a schemaFormat is not provided.
     */
    DEFAULT("application/vnd.aai.asyncapi+json;version=" + AsyncAPI.ASYNCAPI_DEFAULT_VERSION),
    ASYNCAPI_V3("application/vnd.aai.asyncapi;version=" + AsyncAPI.ASYNCAPI_DEFAULT_VERSION),
    ASYNCAPI_V3_JSON("application/vnd.aai.asyncapi+json;version=" + AsyncAPI.ASYNCAPI_DEFAULT_VERSION),
    ASYNCAPI_V3_YAML("application/vnd.aai.asyncapi+yaml;version=" + AsyncAPI.ASYNCAPI_DEFAULT_VERSION),
    JSON_SCHEMA_JSON("application/schema+json;version=draft-07"),
    JSON_SCHEMA_YAML("application/schema+yaml;version=draft-07"),
    AVRO_V1_9_0("application/vnd.apache.avro;version=1.9.0"),
    RAML_V1("application/raml+yaml;version=1.0"),
    PROTOBUF_V2("application/vnd.google.protobuf;version=2"),
    PROTOBUF_V3("application/vnd.google.protobuf;version=3");

    public final String value;

    SchemaFormat(String schemaFormat) {
        this.value = schemaFormat;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
