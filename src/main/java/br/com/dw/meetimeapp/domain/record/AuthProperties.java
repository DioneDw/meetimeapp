package br.com.dw.meetimeapp.domain.record;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth")
public record AuthProperties(String clientId, String redirectUri, String authUrl, String scope) {

}
