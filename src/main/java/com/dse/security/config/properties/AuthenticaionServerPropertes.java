package com.dse.security.config.properties;

public class AuthenticaionServerPropertes {

    private String checkTokenEndpointUrl = "http://localhost:8070/oauth/check_token";

    public String getCheckTokenEndpointUrl() {
        return checkTokenEndpointUrl;
    }

    public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
    }

}
