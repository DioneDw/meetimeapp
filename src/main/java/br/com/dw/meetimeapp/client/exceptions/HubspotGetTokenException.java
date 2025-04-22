package br.com.dw.meetimeapp.client.exceptions;

import br.com.dw.meetimeapp.domain.records.HubspotError;

public class HubspotGetTokenException extends RuntimeException{

    private HubspotError hubspotError;

    public HubspotGetTokenException(HubspotError hubspotError) {
        super(hubspotError.message());
        this.hubspotError = hubspotError;
    }

    public HubspotError getHubspotError() {
        return hubspotError;
    }
}
