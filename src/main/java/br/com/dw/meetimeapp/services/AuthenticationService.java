package br.com.dw.meetimeapp.services;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dw.meetimeapp.domain.record.AuthenticationUrlRecord;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationUrlRecord authenticationUrl;

    public String createUrlAuth() {
        return authenticationUrl.authUrl() +
                "?client_id=" + authenticationUrl.clientId() +
                "&redirect_uri=" + URLEncoder.encode(authenticationUrl.redirectUri(), StandardCharsets.UTF_8) +
                "&scope=" + authenticationUrl.scope() +
                "&response_type=code";
    }
}
