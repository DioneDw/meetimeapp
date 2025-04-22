package br.com.dw.meetimeapp.domain.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PropertiesDTO(@Email String email, @NotBlank String lastName, @NotBlank String firstName) {

}
