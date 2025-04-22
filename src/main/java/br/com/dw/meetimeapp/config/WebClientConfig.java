package br.com.dw.meetimeapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.dw.meetimeapp.domain.records.OAuthProperties;

@Configuration
public class WebClientConfig {

    @Autowired
    private OAuthProperties oAuthProperties;

    @Bean
    public WebClient webClientResource(WebClient.Builder builder){
        return builder
        .baseUrl(oAuthProperties.baseUrl())
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE).build();
    }
}