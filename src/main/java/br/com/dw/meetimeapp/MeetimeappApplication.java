package br.com.dw.meetimeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.dw.meetimeapp.domain.records.AuthProperties;
import br.com.dw.meetimeapp.domain.records.OAuthProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableConfigurationProperties({ AuthProperties.class, OAuthProperties.class })
@OpenAPIDefinition(
	info = @Info(title = "Teste técnico Meetime",
	description = "Aplicação de integração de uma API Rest com o serviço Hubspot",
	contact = @Contact(name="Dione", url = "http://github.com/DioneDw")
	),
	servers = {@Server(url = "http://localhost:8080", description = "Servidor Local")}
)
public class MeetimeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetimeappApplication.class, args);
	}
}
