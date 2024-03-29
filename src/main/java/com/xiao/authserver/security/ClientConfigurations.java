package com.xiao.authserver.security;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oauth2client")
public class ClientConfigurations {

    private String oidcClientId;
    private String oidcClientSecret;
    private String oidcRedirectUri;
    private String oidcPostLogoutRedirectUri;

    public String getOidcClientId() {
        return oidcClientId;
    }

    public void setOidcClientId(String oidcClientId) {
        this.oidcClientId = oidcClientId;
    }

    public String getOidcClientSecret() {
        return oidcClientSecret;
    }

    public void setOidcClientSecret(String oidcClientSecret) {
        this.oidcClientSecret = oidcClientSecret;
    }

    public String getOidcRedirectUri() {
        return oidcRedirectUri;
    }

    public void setOidcRedirectUri(String oidcRedirectUri) {
        this.oidcRedirectUri = oidcRedirectUri;
    }

    public String getOidcPostLogoutRedirectUri() {
        return oidcPostLogoutRedirectUri;
    }

    public void setOidcPostLogoutRedirectUri(String oidcPostLogoutRedirectUri) {
        this.oidcPostLogoutRedirectUri = oidcPostLogoutRedirectUri;
    }
}
