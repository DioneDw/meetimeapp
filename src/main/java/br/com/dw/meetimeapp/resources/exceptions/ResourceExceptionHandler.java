package br.com.dw.meetimeapp.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dw.meetimeapp.client.exceptions.HubspotCreateContactException;
import br.com.dw.meetimeapp.client.exceptions.HubspotGetTokenException;
import br.com.dw.meetimeapp.services.exceptions.InvalidCodeException;
import br.com.dw.meetimeapp.services.exceptions.InvalidTokenException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(InvalidCodeException.class)
    public ResponseEntity<StandardError> invalidCodeException(InvalidCodeException e, HttpServletRequest req){
        String error = "Código informado nulo ou vazio!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError response = new StandardError(Instant.now(),status.value(),error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<StandardError> invalidTokenException(InvalidTokenException e, HttpServletRequest req){
        String error = "Token inválido ou mal formado!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError response = new StandardError(Instant.now(),status.value(),error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(HubspotGetTokenException.class)
    public ResponseEntity<StandartHubspotError> getTokenException(HubspotGetTokenException e){
        String error = "Falha ao obter o token integração Hubspot!";
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        
        StandartHubspotError response = new StandartHubspotError(Instant.now(),status.value(),error,e.getMessage(),e.getHubspotError());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(HubspotCreateContactException.class)
    public ResponseEntity<StandartHubspotError> createContactException(HubspotCreateContactException e){
        String error = "Falha ao criar novo contato integração Hubspot!";
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        StandartHubspotError response = new StandartHubspotError(Instant.now(),status.value(),error,e.getMessage(),e.getHubspotError());
        return ResponseEntity.status(status).body(response);
    }
}
