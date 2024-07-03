package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComponentsIT extends AbstractPluginIT {
    /**
     * tests the existence of all components and their simple attributes
     **/

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(ComponentsIT.class), "testAsyncApi/componentsTest.yaml");
        getScanner().scan(file, "testAsyncApi/componentsTest.yaml", AsyncApiScope.CONTRACT);
    }

    @Test
    void basic() {
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (contract:Contract) RETURN contract");
        assertThat(result.hasResult()).isTrue();
        ContractDescriptor contract = result.getSingleResult()
                .get("contract", ContractDescriptor.class);

        assertThat(contract).isNotNull();
        assertThat(contract.getComponents()).isNotNull();
        assertThat(contract.getChannels()).isEmpty();
        assertThat(contract.getOperations()).isEmpty();
        assertThat(contract.getServers()).isEmpty();
        assertThat(contract.getInfo()).isNull();
    }

    @Test
    void tags() {
        List<TagDescriptor> tags =
                query("MATCH (:Components)-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags).hasSize(1);
    }

    @Test
    void channels() {
        List<ChannelDescriptor> channels =
                query("MATCH (:Components)-[:DEFINES_CHANNEL]->(channels:Channel) return channels").getColumn("channels");
        assertThat(channels).isNotNull();
        assertThat(channels).hasSize(1);
    }

    @Test
    void messages() {
        List<MessageDescriptor> messages =
                query("MATCH (:Components)-[:DEFINES_MESSAGE]->(messages:Message) return messages").getColumn("messages");
        assertThat(messages.size()).isEqualTo(2);
    }

    @Test
    void parameters() {
        List<ParametersDescriptor> parameters =
                query("MATCH (:Components)-[:DEFINES_PARAMETERS]->(parameters:Parameters) return parameters").getColumn("parameters");
        assertThat(parameters.size()).isEqualTo(1);
    }

    @Test
    void externalDocs() {
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (:Components)-[:REFERS_TO_EXTERNAL_DOCUMENTATION]->(externalDocs:ExternalDocumentation) return externalDocs");
        assertThat(result.hasResult()).isTrue();
        ExternalDocsDescriptor externalDoc = result.getSingleResult()
                .get("externalDocs", ExternalDocsDescriptor.class);
        assertThat(externalDoc).isNotNull();
    }

    @Test
    void operationTraits() {
        List<OperationTraitDescriptor> operationTraits =
                query("MATCH (:Components)-[:DEFINES_OPERATION_TRAIT]->(operationTraits:OperationTrait) return operationTraits").getColumn("operationTraits");
        assertThat(operationTraits.size()).isEqualTo(1);
    }

    @Test
    void messageTraits() {
        List<OperationTraitDescriptor> messageTraits =
                query("MATCH (:Components)-[:DEFINES_MESSAGE_TRAIT]->(messageTraits:MessageTrait) return messageTraits").getColumn("messageTraits");
        assertThat(messageTraits.size()).isEqualTo(1);
    }


    //replies, replyAddresses, securitySchemes - no example found
    //not yet supported: schema

}