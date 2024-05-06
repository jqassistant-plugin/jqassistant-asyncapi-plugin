package org.jqassistant.plugin.asyncapi.api.model;

import java.util.Map;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("OAuthFlows")
public interface OAuthFlowDescriptor extends AsyncApiDescriptor {

    String getAuthorizationUrl();

    void setAuthorizationUrl(String authorizationUrl);

    String getTokenUrl();

    void setTokenUrl(String tokenUrl);

    String getRefreshUrl();

    void setRefreshUrl(String refreshUrl);

    Map<String, String> getAvailableScopes();

    void setAvailableScopes(Map<String, String> availableScopes);

}
