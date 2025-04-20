package br.com.dw.meetimeapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.dw.meetimeapp.domain.record.TokenResponse;

@Component
public class HubSpotClient {

    @Autowired
    private WebClient webClient;

    public TokenResponse getToken(MultiValueMap<String,String> form, String baseUrl){
        return webClient.post()
        .uri(baseUrl + "/oauth/v1/token")
        .bodyValue(form)
        .retrieve()
        .bodyToMono(TokenResponse.class)
        .block();
    }

}
