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

class MessageIT extends AbstractPluginIT {
    /**
     * tests a message descriptor for its simple attributes and properites
     **/

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(MessageIT.class), "testAsyncApi/messageTest.yml");
        getScanner().scan(file, "testAsyncApi/messageTest.yml", AsyncApiScope.CONTRACT);
        store.beginTransaction();
    }

    @Test
    public void simpleAttributes() {
        Query.Result<Query.Result.CompositeRowObject> resultC = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {referenceableKey:'oneMessage'}) return message");
        assertThat(resultC.hasResult()).isTrue();
        MessageDescriptor message = resultC.getSingleResult()
                .get("message", MessageDescriptor.class);
        assertThat(message).isNotNull();
        assertThat(message.getReferenceableKey()).isEqualTo("oneMessage");
        assertThat(message.getTitle()).isEqualTo("User signup");
        assertThat(message.getSummary()).isEqualTo("Action to sign a user up.");
        assertThat(message.getDescription()).isEqualTo("A longer description for a specific message.");
        assertThat(message.getContentType()).isEqualTo("application/json");
        store.commitTransaction();
    }

    @Test
    public void tags() {

        //tags in messages
        List<TagDescriptor> tags =
                query("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {referenceableKey:'oneMessage'})-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags.size()).isEqualTo(3);
        store.commitTransaction();
    }

    @Test
    public void correlationId() {
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {referenceableKey:'oneMessage'})-[:HAS_CORRELATION_ID]->(correlationId:CorrelationID) return correlationId");
        assertThat(result.hasResult()).isTrue();
        CorrelationIDDescriptor correlationId = result.getSingleResult().get("correlationId", CorrelationIDDescriptor.class);
        assertThat(correlationId.getDescription()).isEqualTo("Default Correlation ID");
        assertThat(correlationId.getLocation()).isEqualTo("$message.header#/correlationId");
        store.commitTransaction();
    }

    @Test
    public void traits() {
        Query.Result<Query.Result.CompositeRowObject> result2 = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {referenceableKey:'oneMessage'})-[:DEFINES_TRAIT]->(trait:MessageTrait) return trait");
        assertThat(result2.hasResult()).isTrue();
        assertThat(result2.getSingleResult().get("trait", MessageTraitDescriptor.class)).isNotNull();
        store.commitTransaction();
    }

    @Test
    public void examples() {
        Query.Result<Query.Result.CompositeRowObject> result3 = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {referenceableKey:'oneMessage'})-[:HAS_EXAMPLE]->(example:MessageExample) return example");
        assertThat(result3.hasResult()).isTrue();
        MessageExampleDescriptor example = result3.getSingleResult().get("example", MessageExampleDescriptor.class);
        assertThat(example).isNotNull();
        assertThat(example.getName()).isEqualTo("SimpleSignup");
        assertThat(example.getSummary()).isEqualTo("A simple UserSignup example message");
        store.commitTransaction();

    }


}