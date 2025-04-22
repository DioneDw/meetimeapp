package br.com.dw.meetimeapp.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dw.meetimeapp.client.ContactClient;
import br.com.dw.meetimeapp.domain.dto.contact.ContactCreateDTO;
import br.com.dw.meetimeapp.domain.dto.contact.ContactResponseDTO;
import br.com.dw.meetimeapp.services.exceptions.InvalidTokenException;

@Service
public class ContactService {

    @Autowired
    private ContactClient contactClient;


    public ContactResponseDTO create(ContactCreateDTO dto, String authorizationHeaderContent){
        if(authorizationHeaderContent == null || !authorizationHeaderContent.startsWith("Bearer ")){
            throw new InvalidTokenException();
        }

        String tokenHubspot = authorizationHeaderContent.replace("Bearer ","").trim();

        Map<String,String> dataProperties = new HashMap<>();
        dataProperties.put("email",dto.properties().email());
        dataProperties.put("lastname",dto.properties().lastName());
        dataProperties.put("firstname",dto.properties().firstName());

        Map<String,Object> properties = new HashMap<>();
        properties.put("properties",dataProperties);

        return contactClient.createContact(properties, tokenHubspot);
    }
}
