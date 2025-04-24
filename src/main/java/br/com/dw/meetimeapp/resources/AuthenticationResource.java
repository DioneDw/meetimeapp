package br.com.dw.meetimeapp.resources;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dw.meetimeapp.domain.records.TokenResponse;
import br.com.dw.meetimeapp.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Tag(name = "Autenticação e Callback")
public class AuthenticationResource {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(
        description = "Realiza a chamada de autenticação que redireciona para a plataforma Hubspot.",
        summary = "Realiza o redirecionamento para autenticação Hubspot."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "302", description = "Redireciona para autenticação, código obtido"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    }
    )
    @GetMapping(value = "/auth")
    public ResponseEntity<String> redirectToHubspotAuthorization() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(authenticationService.buildAuthorizationUrl()))
                .build();
    }


    @Operation(
        description = "Realizada automaticamente após autenticação, realizando a troca do código de autorização por um token que será utilizado para acessos aos recursos",
        summary = "Realiza automaticamente troca de código por token."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Token Retornado com Sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro: Código informado nulo ou vazio."),
    })
    @GetMapping(value = "/oauth/callback")
    public ResponseEntity<TokenResponse> exchangeCodeForTokenHubspot(@RequestParam String code) {
        return ResponseEntity.ok().body(authenticationService.getAccessTokenFromCode(code));
    }
}
