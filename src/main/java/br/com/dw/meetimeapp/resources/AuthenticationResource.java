package br.com.dw.meetimeapp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dw.meetimeapp.services.AuthenticationService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationResource {
    
    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping
    public ResponseEntity<String> redirectToAuth(){
        return ResponseEntity
        .status(HttpStatus.FOUND)
        .location(URI.create(authenticationService.createUrlAuth()))
        .build();
    }

}
