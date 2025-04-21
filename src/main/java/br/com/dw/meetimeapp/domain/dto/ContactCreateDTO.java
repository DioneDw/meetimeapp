package br.com.dw.meetimeapp.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactCreateDTO(@Email String email, @NotBlank String lastName, @NotBlank String firstName) {
    
}
