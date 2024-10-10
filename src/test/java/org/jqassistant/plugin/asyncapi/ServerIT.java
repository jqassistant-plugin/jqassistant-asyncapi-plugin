package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServerIT extends AbstractPluginIT {
    /**
     * tests server for simple attributes and properties
     **/

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(TagIT.class), "testAsyncApi/serverTest.yaml");
        getScanner().scan(file, "testAsyncApi/serverTest.yaml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
    }

    @Test
    public void simpleAttributes() {
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery(
                "MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server) return server");
        assertThat(result.hasResult()).isTrue();
        ServerDescriptor server = result.getSingleResult()
                .get("server", ServerDescriptor.class);

        assertThat(server.getProtocol()).isEqualTo("kafka");
        assertThat(server.getProtocolVersion()).isEqualTo("3.3.0");
        assertThat(server.getDescription()).isEqualTo("A Kafka cluster running in **OpenShift**.");
        assertThat(server.getHost()).isEqualTo("localhost:4747");
        assertThat(server.getPathName()).isEqualTo("This/Is/A/Path/To/A/Resource/In/The/Host");
        store.commitTransaction();
    }

    @Test
    public void tags() {
        List<TagDescriptor> tags =
                query("MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server)-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags.size()).isEqualTo(3);
        store.commitTransaction();

    }

    @Test
    public void externalDocs() {
        Query.Result<Query.Result.CompositeRowObject> result2 = store.executeQuery(
                "MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server)-[:REFERS_TO_EXTERNAL_DOCUMENTATION]->(externalDocs:ExternalDocumentation) return externalDocs");
        assertThat(result2.hasResult()).isTrue();
        ExternalDocsDescriptor externalDoc = result2.getSingleResult()
                .get("externalDocs", ExternalDocsDescriptor.class);
        assertThat(externalDoc).isNotNull();
        assertThat(externalDoc.getDescription()).isEqualTo("More info about Kafka");
        assertThat(externalDoc.getUrl()).isEqualTo("https://www.ibm.com/docs/en/dsm?topic=options-apache-kafka-protocol-configuration");
        store.commitTransaction();
    }

    @Test
    public void serverVariables() {
        List<ServerVariableDescriptor> variables =
                query("MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server)-[:DEFINES_SERVER_VARIABLE]->(var:ServerVariable) return var").getColumn("var");
        assertThat(variables.size()).isEqualTo(2);
        ServerVariableDescriptor var = variables.get(0);
        assertThat(var.getReferenceableKey()).isEqualTo("host");
        assertThat(var.getDefaultValue()).isEqualTo("apps.dale-lane.cp.fyre.ibm.com");
        assertThat(var.getDescription()).isEqualTo("hostname for the OpenShift cluster");
        assertThat(var.getExamples()).isEqualTo("[apps.dale-lane.cp.fyre.ibm.com, apps.dalelane-neptune.cp.fyre.ibm.com]");
        assertThat(var.getEnumValues()).isEqualTo("[production, staging]");
        store.commitTransaction();
    }

    @Test
    public void securityScheme() {
        //security scheme TODO: extended test
        List<SecuritySchemeDescriptor> security =
                query("MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server)-[:DEFINES_SECURITY_SCHEME]->(securitySchemes:SecurityScheme) return securitySchemes").getColumn("securitySchemes");
        assertThat(security.get(0)).isNotNull();
        assertThat(security.size()).isEqualTo(1);
        store.commitTransaction();
    }

    @Test
    public void bindings() {
        List<ServerBindingsDescriptor> bindings =
                query("MATCH (:Contract)-[:DEFINES_SERVER]->(server:Server)-[:DEFINES_SERVER_BINDING]->(binding:ServerBindings) return binding").getColumn("binding");
        assertThat(bindings.get(0)).isNotNull();
        assertThat(bindings.size()).isEqualTo(1);
        store.commitTransaction();

    }

}
