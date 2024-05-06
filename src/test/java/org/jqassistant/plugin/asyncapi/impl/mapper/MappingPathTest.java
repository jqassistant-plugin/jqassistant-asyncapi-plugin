package org.jqassistant.plugin.asyncapi.impl.mapper;

import org.jqassistant.plugin.asyncapi.impl.mapper.service.MappingPath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MappingPathTest {

    @Test
    void treeTraversal() {
        MappingPath mappingPath = new MappingPath();
        assertThat(mappingPath.isEmpty()).isEqualTo(true);

        mappingPath.enter("components");
        mappingPath.enter("tags");
        assertThat(mappingPath.isEmpty()).isEqualTo(false);
        assertThat(mappingPath.getPath()).isEqualTo("#/components/tags");

        mappingPath.leave();
        assertThat(mappingPath.getPath()).isEqualTo("#/components");

        mappingPath.leave();
        assertThat(mappingPath.isEmpty()).isEqualTo(true);
    }

}