package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("OAuthFlows")
public interface OAuthFlowsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {

    @Relation("IMPLICIT_FLOW")
    OAuthFlowDescriptor getImplicitFlow();

    void setImplicitFlow(OAuthFlowDescriptor implicit);

    @Relation("PASSWORD_FLOW")
    OAuthFlowDescriptor getPasswordFlow();

    void setPasswordFlow(OAuthFlowDescriptor password);

    @Relation("CLIENT_CREDENTIALS_FLOW")
    OAuthFlowDescriptor getClientCredentials();

    void setClientCredentials(OAuthFlowDescriptor clientCredentials);

    @Relation("AUTHORIZATION_CODE_FLOW")
    OAuthFlowDescriptor getAuthorizationCode();

    void setAuthorizationCode(OAuthFlowDescriptor authorizationCode);

}
