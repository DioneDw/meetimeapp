package br.com.dw.meetimeapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dw.meetimeapp.domain.dto.HubspotEventResponseDTO;
import br.com.dw.meetimeapp.services.exceptions.WebhookException;

@Service
public class WebhookService {
    
    public String verifyEventCreateContact(List<HubspotEventResponseDTO> events){
        if(events.size() == 0){
            throw new WebhookException();
        }

        for(HubspotEventResponseDTO event : events){
            if("contact.creation".equals(event.subscriptionType())){
                String text = "Evento de criação de contato escutado, contato de id: " + event.objectId();
                return text;
            }
        }
        return "";
    }
}
