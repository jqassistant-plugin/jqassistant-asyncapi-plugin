package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.report.api.model.Column;
import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Concept;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.buschmais.jqassistant.core.report.api.model.Result.Status.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class AsyncApiIT extends AbstractPluginIT {

    @Test
    void resolveReferences() throws RuleException {
        File file = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/channelsTest.yml");
        getScanner().scan(file, "testAsyncApi/channelsTest.yml", AsyncApiScope.CONTRACT);
        Result<Concept> result = applyConcept("asyncapi:References");
        assertThat(result.getStatus()).isEqualTo(SUCCESS);
        Column<?> references = result.getRows().get(0).getColumns().get("References");
        assertThat(references).isNotNull();
        assertThat(references.getValue()).isEqualTo(1L);
    }
}
