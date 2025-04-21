package br.com.dw.meetimeapp.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.dw.meetimeapp.client.exceptions.HubspotCreateContactException;
import br.com.dw.meetimeapp.domain.dto.ContactResponseDTO;
import reactor.core.publisher.Mono;

@Component
public class ContactClient {

    @Autowired
    private WebClient webClient;

    public ContactResponseDTO createContact(Map<String,Object> form, String token){
        return webClient.post()
        .uri("/crm/v3/objects/contacts")
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(form)
        .retrieve()
        .onStatus(
            status -> status.isError(),
            response -> response.bodyToMono(String.class)
            .flatMap(error -> Mono.error(new HubspotCreateContactException(error)))
        )
        .bodyToMono(ContactResponseDTO.class)
        .block();
    }

}

