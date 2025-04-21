package br.com.dw.meetimeapp.domain.record;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "auth")
@Validated
public record AuthProperties(@NotBlank String clientId, @NotBlank String redirectUri, @NotBlank String authUrl, @NotBlank String scope) {

}
