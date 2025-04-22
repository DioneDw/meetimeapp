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
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/contact")
public class ContactResource {

    @Autowired
    private ContactService contactService;
    
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
