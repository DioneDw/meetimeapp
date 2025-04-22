package br.com.dw.meetimeapp.domain.records;

public record TokenResponse(String refresh_token, String access_token, Long expires_in) {
}
