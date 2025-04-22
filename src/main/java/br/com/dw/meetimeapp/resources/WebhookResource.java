package br.com.dw.meetimeapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dw.meetimeapp.domain.dto.HubspotEventResponseDTO;
import br.com.dw.meetimeapp.services.WebhookService;


@RestController
@RequestMapping(value="/webhook")
public class WebhookResource {

    @Autowired
    private WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> listenerContactCreate(@RequestBody List<HubspotEventResponseDTO> events){
        String response = webhookService.verifyEventCreateContact(events);
        if(!"".equals(response)){
            System.out.println(response);
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
