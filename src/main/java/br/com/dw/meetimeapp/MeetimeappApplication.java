package br.com.dw.meetimeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.dw.meetimeapp.domain.record.AuthenticationUrlRecord;

@SpringBootApplication
@EnableConfigurationProperties(AuthenticationUrlRecord.class)

public class MeetimeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetimeappApplication.class, args);
	}

}
