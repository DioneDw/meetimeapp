package br.com.dw.meetimeapp.services;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import br.com.dw.meetimeapp.client.HubSpotClient;
import br.com.dw.meetimeapp.domain.records.AuthProperties;
import br.com.dw.meetimeapp.domain.records.OAuthProperties;
import br.com.dw.meetimeapp.domain.records.TokenResponse;
import br.com.dw.meetimeapp.services.exceptions.InvalidCodeException;

@Service
public class AuthenticationService {

    @Autowired
    private AuthProperties authProperties;

    @Autowired
    private OAuthProperties oAuthProperties;

    @Autowired
    private HubSpotClient hubSpotClient;


    public String buildAuthorizationUrl() {
        return authProperties.authUrl() +
                "?client_id=" + authProperties.clientId() +
                "&redirect_uri=" + URLEncoder.encode(authProperties.redirectUri(), StandardCharsets.UTF_8) +
                "&scope=" + URLEncoder.encode(authProperties.scope(), StandardCharsets.UTF_8) +
                "&response_type=code";
    }

    public TokenResponse getAccessTokenFromCode(String code) {
        if(code.isBlank() || code == null){
            throw new InvalidCodeException();
        }

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", oAuthProperties.grantType());
        form.add("client_id", oAuthProperties.clientId());
        form.add("client_secret", oAuthProperties.clientSecret());
        form.add("redirect_uri", oAuthProperties.redirectUri());
        form.add("code", code);

        return hubSpotClient.getToken(form);
    }
}
