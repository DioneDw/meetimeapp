package br.com.dw.meetimeapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dw.meetimeapp.domain.dto.HubspotEventResponseDTO;
import br.com.dw.meetimeapp.services.WebhookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value="/webhook")
public class WebhookResource {

    @Autowired
    private WebhookService webhookService;

    @Operation(
        description = "Escuta a chamada externa de criação de contato na plataforma Hubspot",
        summary = "Escuta criação de contato Hubspot"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento recebido com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    })
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

    @Operation(
        description = "Recupera uma síntese da lista de eventos que a aplicação recebeu via webhook do Hubspot",
        summary = "Recupe lista de eventos vindos do webhook."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evento recebido com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @GetMapping(value = "/webhook/events")
    public ResponseEntity<List<String>> getEvents(){
        return ResponseEntity.ok().body(webhookService.getAllEvents());
    }
}
