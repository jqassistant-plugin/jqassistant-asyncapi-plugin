package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MessageIT extends AbstractPluginIT {
    /**
     * tests a message descriptor for its simple attributes and properites
     **/
    @Test
    public void test() {
        File file = new File(getClassesDirectory(MessageIT.class), "testAsyncApi/messageTest.yml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/messageTest.yml", AsyncApiScope.CONTRACT);

        store.beginTransaction();
        assertThat(contract).isNotNull();

        //simple attributes
        Query.Result<Query.Result.CompositeRowObject> resultC = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {name:'oneMessage'}) return message");
        assertThat(resultC.hasResult()).isTrue();
        MessageDescriptor message = resultC.getSingleResult()
                .get("message", MessageDescriptor.class);
        assertThat(message).isNotNull();
        assertThat(message.getName()).isEqualTo("oneMessage"); //TODO: Should be the acutal name "UserSignup" but gets overwritten by the name of the path name of the message
        assertThat(message.getTitle()).isEqualTo("User signup");
        assertThat(message.getSummary()).isEqualTo("Action to sign a user up.");
        assertThat(message.getDescription()).isEqualTo("A longer description for a specific message.");
        assertThat(message.getContentType()).isEqualTo("application/json");

        //tags in messages
        List<TagDescriptor> tags =
                query("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {name:'oneMessage'})-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags.size()).isEqualTo(3);

        //correlation Id
        Query.Result<Query.Result.CompositeRowObject> result = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {name:'oneMessage'})-[:HAS_CORRELATION_ID]->(correlationId:CorrelationID) return correlationId");
        assertThat(result.hasResult()).isTrue();
        CorrelationIDDescriptor correlationId = result.getSingleResult().get("correlationId", CorrelationIDDescriptor.class);
        assertThat(correlationId.getDescription()).isEqualTo("Default Correlation ID");
        assertThat(correlationId.getLocation()).isEqualTo("$message.header#/correlationId");

        // message traits
        Query.Result<Query.Result.CompositeRowObject> result2 = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {name:'oneMessage'})-[:DEFINES_TRAIT]->(trait:Message_Trait) return trait");
        assertThat(result2.hasResult()).isTrue();
        assertThat(result2.getSingleResult().get("trait", MessageTraitDescriptor.class)).isNotNull();

        //message examples
        Query.Result<Query.Result.CompositeRowObject> result3 = store.executeQuery("MATCH (:Channel)-[:SUPPORTS_MESSAGE]->(message:Message {name:'oneMessage'})-[:HAS_EXAMPLE]->(example:Message_Example) return example");
        assertThat(result3.hasResult()).isTrue();
        MessageExampleDescriptor example = result3.getSingleResult().get("example", MessageExampleDescriptor.class);
        assertThat(example).isNotNull();
        assertThat(example.getName()).isEqualTo("SimpleSignup");
        assertThat(example.getSummary()).isEqualTo("A simple UserSignup example message");
        store.commitTransaction();

    }


}