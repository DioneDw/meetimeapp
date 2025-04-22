package br.com.dw.meetimeapp.domain.records;

public record HubspotError(String status,String message,String correlationId,String category)
{
}