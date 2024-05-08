package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;

@Label("SecurityScheme")
public interface SecuritySchemeDescriptor extends AsyncApiDescriptor {

    String getType();

    void setType(String type);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getIn();

    void setIn(String in);

    String getScheme();

    void setScheme(String scheme);

    String getBearerFormat();

    void setBearerFormat(String bearerFormat);

    String getOpenIdConnectUrl();

    void setOpenIdConnectUrl(String openIdConnectUrl);

    //should be an Array
    String getScopes();

    void setScopes(String scopes);

    @Relation("HAS_FLOWS")
    OAuthFlowsDescriptor getOAuthFlows();

    void setOAuthFlows(OAuthFlowsDescriptor flows);

    @Relation("HAS_BINDING")
    List<MessageBindingsDescriptor> setBindings();

    void getBindings(List<MessageBindingsDescriptor> bindings);

}
