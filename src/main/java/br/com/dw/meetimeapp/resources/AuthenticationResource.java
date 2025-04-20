package br.com.dw.meetimeapp.resources;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dw.meetimeapp.domain.record.TokenResponse;
import br.com.dw.meetimeapp.services.AuthenticationService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthenticationResource {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping(value = "/auth")
    public ResponseEntity<String> redirectToHubspotAuthorization() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(authenticationService.buildAuthorizationUrl()))
                .build();
    }

    @GetMapping(value = "/oauth/callback")
    public ResponseEntity<TokenResponse> exchangeCodeForTokenHubspot(@RequestParam String code) {
        return ResponseEntity.ok().body(authenticationService.getAccessTokenFromCode(code));
    }
}
