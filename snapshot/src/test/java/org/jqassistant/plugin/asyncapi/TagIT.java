package org.jqassistant.plugin.asyncapi;

import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import com.buschmais.xo.api.Query;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.TagDescriptor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TagIT extends AbstractPluginIT {
    /**
     * tests simple tags
     **/

    @Test
    public void test() {
        store.beginTransaction();
        File file = new File(getClassesDirectory(TagIT.class), "testAsyncApi/tagsTest.yml");
        getScanner().scan(file, "testAsyncApi/tagsTest.yml", AsyncApiScope.CONTRACT);

        List<TagDescriptor> tags =
                query("MATCH (:Contract)-[:DEFINES_INFO]->(:Info)-[:HAS_TAG]->(tags:Tag) return tags").getColumn("tags");
        assertThat(tags.size()).isEqualTo(7);

        //reference tag
        Query.Result<Query.Result.CompositeRowObject> referenceTag = store.executeQuery(
                "MATCH (:Contract)-[:DEFINES_INFO]->(:Info)-[:HAS_TAG]->(ref:Reference{reference:'#/components/tags/kafka'}) return ref");
        assertThat(referenceTag.hasResult()).isTrue();

        //normal tag
        Query.Result<Query.Result.CompositeRowObject> tag = store.executeQuery(
                "MATCH (:Contract)-[:DEFINES_INFO]->(:Info)-[:HAS_TAG]->(tag:Tag{name:'Diffs'}) return tag");
        TagDescriptor secondTag = tag.getSingleResult()
                .get("tag", TagDescriptor.class);

        assertThat(secondTag.getDescription()).isEqualTo("Diff summary of changes in the API");
        assertThat(secondTag.getName()).isEqualTo("Diffs");
        assertThat(secondTag.getExternalDocs().getDescription()).isEqualTo("Modo Jeans use of Kafka");
        assertThat(secondTag.getExternalDocs().getUrl()).isEqualTo("https://modojeans.com/intranet/kafka");
        store.commitTransaction();
    }
}