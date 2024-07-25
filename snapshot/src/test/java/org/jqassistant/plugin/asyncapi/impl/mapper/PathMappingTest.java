package org.jqassistant.plugin.asyncapi.impl.mapper;

import org.jqassistant.plugin.asyncapi.impl.mapper.service.AsyncApiContext;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathMappingTest {

    @Test
    void treeTraversal() {
        AsyncApiContext context = new AsyncApiContext();
        assertThat(context.isEmpty()).isEqualTo(true);

        context.enter("components");
        context.enter("tags");
        assertThat(context.isEmpty()).isEqualTo(false);
        assertThat(context.getPath()).isEqualTo("#/components/tags");

        context.leave();
        assertThat(context.getPath()).isEqualTo("#/components");

        context.leave();
        assertThat(context.isEmpty()).isEqualTo(true);
    }

}