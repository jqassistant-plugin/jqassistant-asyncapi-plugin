package org.jqassistant.plugin.asyncapi;

import java.io.File;
import java.util.List;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;

import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InfoIT extends AbstractPluginIT {
    /**
     * tests the info descriptor for its attributes
     **/

    InfoDescriptor info;

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(InfoIT.class), "testAsyncApi/infoTest.yaml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/infoTest.yaml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
        assertThat(contract).isNotNull();
        assertThat(contract.getComponents()).isNull();
        info = contract.getInfo();
        assertThat(info).isNotNull();
    }

    @AfterEach
    public void closeTransaction() {
        store.commitTransaction();
    }

    @Test
    void simpleAttributes() {
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
    }

    @Test
    void infoTags() {
        List<TagDescriptor> tags = info.getTags();
        assertThat(tags).isNotNull();
        for (TagDescriptor tag : tags) {
            if ((tag.getName() != null) && tag.getName()
                    .equals("second tag")) {
                assertThat(tag.getExternalDocs()).isNotNull();
                assertThat(tag.getExternalDocs()
                        .getDescription()).isEqualTo("Modo Jeans use of Kafka");
            } else if (tag.getName() == null) {
                assertThat(((ReferenceDescriptor) tag).getReference()).isEqualTo("#/components/tags/kafka");
            }
        }
    }

    @Test
    void externalDocsOfInfo() {
        ExternalDocsDescriptor externalDoc = info.getExternalDocs();
        assertThat(externalDoc).isNotNull();
        assertThat(externalDoc.getDescription()).isEqualTo("Background about the spec");
        assertThat(externalDoc.getUrl()).isEqualTo("https://www.asyncapi.com/docs/reference/specification/v3.0.0-next-major-spec.8");
    }

}