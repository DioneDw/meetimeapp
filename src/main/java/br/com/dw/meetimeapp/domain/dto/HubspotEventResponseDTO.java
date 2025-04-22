package br.com.dw.meetimeapp.domain.dto;

public record HubspotEventResponseDTO(
    Long appId,
    Long eventId,
    Long subscriptionId,
    Long portalId,
    Long occurredAt,
    String subscriptionType,
    Long attemptNumber,
    Long objectId,
    String changeSource,
    String changeFlag
    )
{
}
