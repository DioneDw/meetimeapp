package br.com.dw.meetimeapp.domain.record;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "oauth")
@Validated
public record OAuthProperties(@NotBlank String authUri, @NotBlank String grantType, @NotBlank String clientId, @NotBlank String clientSecret,
        @NotBlank String redirectUri) {

}
