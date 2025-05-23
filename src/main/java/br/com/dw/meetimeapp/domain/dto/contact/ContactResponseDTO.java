package br.com.dw.meetimeapp.domain.dto.contact;

public record ContactResponseDTO(
    String createdAt,
    boolean archived,
    String archivedAt,
    Object propertiesWithHistory,
    String id,
    String objectWriteTraceId,
    Object properties,
    String updatedAt
) {
    
}
