package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;

@Label("Topic_Configuration")
public interface TopicConfigurationDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

    String getCleanupPolicy();

    void setCleanupPolicy(String cleanupPolicy);

    long getRetentionMS();

    void setRetentionMS(long retentionMs);

    long getRetentionBytes();

    void setRetentionBytes(long retentionBytes);

    long getDeleteRetentionMS();

    void setDeleteRetentionMS(long deleteRetentionMs);

    int getMaxMessageBytes();

    void setMaxMessageBytes(int maxMessageBytes);

    boolean getConfluentKeySchemaValidation();

    void setConfluentKeySchemaValidation(boolean confluentKeySchemaValidation);

    String getConfluentKeySubjectNameStrategy();

    void setConfluentKeySubjectNameStrategy(String confluentKeySubjectNameStrategy);

    boolean getConfluentValueSchemaValidation();

    void setConfluentValueSchemaValidation(boolean confluentValueSchemaValidation);

    String getConfluentValueSubjectNameStrategy();

    void setConfluentValueSubjectNameStrategy(String confluentValueSubjectNameStrategy);

}