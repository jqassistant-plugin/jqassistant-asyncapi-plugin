package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InfoIT extends AbstractPluginIT {

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(InfoIT.class), "testAsyncApi/infoTest.yaml");
        getScanner().scan(file, "testAsyncApi/infoTest.yaml", AsyncApiScope.CONTRACT);
    }

    @Test
    void basic() {
        store.beginTransaction();

        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (contract:Contract) RETURN contract");
        assertThat(result.hasResult()).isTrue();
        ContractDescriptor contract = result.getSingleResult()
                .get("contract", ContractDescriptor.class);
        assertThat(contract).isNotNull();
        assertThat(contract.getComponents()).isNull();
        assertThat(contract.getChannels()).isEmpty();
        assertThat(contract.getOperations()).isEmpty();
        assertThat(contract.getServers()).isEmpty();
        store.commitTransaction();
    }

    @Test
    void simpleAttributes() {
        store.beginTransaction();
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (:Contract)-[:DEFINES_INFO]->(info:Info) RETURN info");
        assertThat(result.hasResult()).isTrue();
        InfoDescriptor info = result.getSingleResult()
                .get("info", InfoDescriptor.class);

        assertThat(info.getTitle()).isEqualTo("Short info Async API File");
        assertThat(info.getDescription()).isEqualTo("This short API File is for test purposes only. It includes nothing but the info with its properties.");
        assertThat(info.getTermsOfService()).isEqualTo("https://infotest.co.uk/asyncapi/terms-of-service");
        LicenseDescriptor license = info.getLicense();
        assertThat(license.getName()).isEqualTo("TestLicense 1.0");
        assertThat(license.getUrl()).isEqualTo("https://www.apache.org/licenses/LICENSE-2.0.html");
        ContactDescriptor contact = info.getContact();
        assertThat(contact.getName()).isEqualTo("Dale Lane");
        assertThat(contact.getUrl()).isEqualTo("https://dalelane.co.uk");
        assertThat(contact.getEmail()).isEqualTo("test@info.de");
        store.commitTransaction();
    }

    @Test
    void infoTags() {
        store.beginTransaction();
        List<TagDescriptor> tags = query("MATCH (:Contract)-[:DEFINES_INFO]->(info:Info)-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags).hasSize(3);
        for (TagDescriptor tag : tags) {
            if ((tag.getName() != null) && tag.getName()
                    .equals("second tag")) {
                assertThat(tag.getExternalDocs()).isNotNull();
                assertThat(tag.getExternalDocs()
                        .getDescription()).isEqualTo("Modo Jeans use of Kafka");
            } else if (tag.getName() == null) {
                ReferenceDescriptor referenceTag = (ReferenceDescriptor) tag;
                assertThat(referenceTag.getReference()).isEqualTo("#/components/tags/kafka");
            }
        }
        store.commitTransaction();
    }

    @Test
    void externalDocsOfInfo() {
        store.beginTransaction();
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery(
                "MATCH (:Info)-[:REFERS_TO_EXTERNAL_DOCUMENTATION]->(externalDocs:ExternalDocumentation) return externalDocs");
        assertThat(result.hasResult()).isTrue();
        ExternalDocsDescriptor externalDoc = result.getSingleResult()
                .get("externalDocs", ExternalDocsDescriptor.class);
        assertThat(externalDoc).isNotNull();
        assertThat(externalDoc.getDescription()).isEqualTo("Background about the spec");
        assertThat(externalDoc.getUrl()).isEqualTo("https://www.asyncapi.com/docs/reference/specification/v3.0.0-next-major-spec.8");
        store.commitTransaction();
    }

}