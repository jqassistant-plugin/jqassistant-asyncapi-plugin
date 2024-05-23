package org.jqassistant.plugin.asyncapi.concept;

import com.buschmais.jqassistant.core.report.api.model.Result;
import com.buschmais.jqassistant.core.rule.api.model.Concept;
import com.buschmais.jqassistant.core.rule.api.model.RuleException;
import com.buschmais.jqassistant.core.test.plugin.AbstractPluginIT;
import org.jqassistant.plugin.asyncapi.api.AsyncApiScope;
import org.jqassistant.plugin.asyncapi.api.model.ContractDescriptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class AsyncApiIT extends AbstractPluginIT {

    @BeforeEach
    public void init() {
        File file = new File(getClassesDirectory(AsyncApiIT.class), "testAsyncApi/channelsTest.yaml");
        ContractDescriptor contract = getScanner().scan(file, "testAsyncApi/channelsTest.yaml", AsyncApiScope.CONTRACT);
    }

    @Test
    void resolveReferences() throws RuleException {
        Result<Concept> result = applyConcept("asyncapi:References");
        assertThat(result.getRows().size()).isEqualTo(1);
    }
}
