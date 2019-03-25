package com.dse.security.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.dse.as")
public class ResourceServerProperties {

    private AuthenticaionServerPropertes authenticaionServer = new AuthenticaionServerPropertes();

    private AuthenticationClientProperties client = new AuthenticationClientProperties();

    public AuthenticationClientProperties getClient() {
        return client;
    }

    public void setClient(AuthenticationClientProperties client) {
        this.client = client;
    }

    public AuthenticaionServerPropertes getAuthenticaionServer() {
        return authenticaionServer;
    }

    public void setAuthenticaionServer(AuthenticaionServerPropertes authenticaionServer) {
        this.authenticaionServer = authenticaionServer;
    }
}
