package com.dse.security.config;


import com.dse.security.config.handler.DseAuthenticationEntryPoint;
import com.dse.security.config.properties.ResourceServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@EnableResourceServer
public class DseOAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerProperties resourceServerProperties;


    @Bean
    public DseAuthenticationEntryPoint dseAuthenticationEntryPoint() {
        return new DseAuthenticationEntryPoint();
    }

    @Bean
    public RemoteTokenServices remoteTokenServices() {
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        UserAuthenticationConverter userAuthenticationConverter = new DseUserAuthenticationConverter();
        tokenConverter.setUserTokenConverter(userAuthenticationConverter);

        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setAccessTokenConverter(tokenConverter);
        remoteTokenServices.setClientId(resourceServerProperties.getClient().getClientId());
        remoteTokenServices.setClientSecret(resourceServerProperties.getClient().getClientSecret());
        remoteTokenServices.setCheckTokenEndpointUrl(resourceServerProperties.getAuthenticaionServer().getCheckTokenEndpointUrl());
        return remoteTokenServices;
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(dseAuthenticationEntryPoint());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests().antMatchers(StringUtils.commaDelimitedListToStringArray(resourceServerProperties.getClient().getResource4Permit())).permitAll().anyRequest().authenticated();
    }
}
