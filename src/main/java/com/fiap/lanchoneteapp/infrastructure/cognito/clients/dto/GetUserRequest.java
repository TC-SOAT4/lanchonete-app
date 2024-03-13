package com.fiap.lanchoneteapp.infrastructure.cognito.clients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class GetUserRequest {

    @JsonProperty("AccessToken")
    private String accessToken;

}
