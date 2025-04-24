package br.com.dw.meetimeapp.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dw.meetimeapp.domain.dto.contact.ContactCreateDTO;
import br.com.dw.meetimeapp.domain.dto.contact.ContactResponseDTO;
import br.com.dw.meetimeapp.services.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/contact")
public class ContactResource {

    @Autowired
    private ContactService contactService;
    

    @Operation(
        description = "Cria um novo contato no CRM na plataforma Hubspot.",
        summary = "Criar novo contato hubspot.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = 
            @Content(schema = 
                @Schema(implementation = ContactCreateDTO.class)
                )
            ))
        @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado usuário com sucesso"),
            @ApiResponse(responseCode = "502", description = "Erro ao criar usuário, erro integração hubspot")
        })
    @PostMapping
    public ResponseEntity<ContactResponseDTO> create(@RequestBody @Valid ContactCreateDTO dto, @RequestHeader("Authorization") String authorizationHeaderContent){
        ContactResponseDTO response = contactService.create(dto,authorizationHeaderContent);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(response.id())
            .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
