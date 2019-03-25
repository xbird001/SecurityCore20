package com.dse.security.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import java.util.Map;

public class DseUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey("additional")) {
            Object principal = map.get("additional");
            return new UsernamePasswordAuthenticationToken(principal, "N/A", null);
        }
        return null;
    }
}
