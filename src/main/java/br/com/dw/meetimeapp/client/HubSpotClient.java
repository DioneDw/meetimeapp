package br.com.dw.meetimeapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.dw.meetimeapp.client.exceptions.HubspotGetTokenException;
import br.com.dw.meetimeapp.domain.records.HubspotError;
import br.com.dw.meetimeapp.domain.records.TokenResponse;
import reactor.core.publisher.Mono;

@Component
public class HubSpotClient {

    @Autowired
    private WebClient webClient;

    public TokenResponse getToken(MultiValueMap<String,String> form){
        return webClient.post()
        .uri("/oauth/v1/token")
        .bodyValue(form)
        .retrieve()
        .onStatus(
            status -> status.isError(),
            response -> response.bodyToMono(HubspotError.class)
            .flatMap(error -> Mono.error(new HubspotGetTokenException(error)))
        )
        .bodyToMono(TokenResponse.class)
        .block();
    }

}
