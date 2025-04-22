package br.com.dw.meetimeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.dw.meetimeapp.domain.records.AuthProperties;
import br.com.dw.meetimeapp.domain.records.OAuthProperties;

@SpringBootApplication
@EnableConfigurationProperties({ AuthProperties.class, OAuthProperties.class })
public class MeetimeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetimeappApplication.class, args);
	}
}
