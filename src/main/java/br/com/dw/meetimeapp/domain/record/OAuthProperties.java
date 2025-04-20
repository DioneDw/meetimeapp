package br.com.dw.meetimeapp.domain.record;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth")
public record OAuthProperties(String authUri, String grantType, String clientId, String clientSecret,
        String redirectUri) {

}
