package br.com.dw.meetimeapp.resources.exceptions;

import java.time.Instant;

import br.com.dw.meetimeapp.domain.records.HubspotError;
import lombok.Getter;

@Getter
public class StandartHubspotError extends StandardError{

    private final String correlationId;
    private final String category;

    public StandartHubspotError(Instant timestamp, Integer status, String error, String message, HubspotError hubspotError) {
        super(timestamp, status, error, message);
        this.correlationId = hubspotError.correlationId();
        this.category = hubspotError.category();
    }
}
