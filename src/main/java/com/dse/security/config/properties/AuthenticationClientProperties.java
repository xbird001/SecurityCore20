package com.dse.security.config.properties;

public class AuthenticationClientProperties {

    /**
     * 第三方账户ID
     */
    private String clientId = "dse1";

    /**
     * 第三方账户密码
     */
    private String clientSecret = "dse123456";

    /**
     * 无需登录验证可以访问的资源
     */
    private String resource4Permit;

    public String getResource4Permit() {
        return resource4Permit;
    }

    public void setResource4Permit(String resource4Permit) {
        this.resource4Permit = resource4Permit;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
