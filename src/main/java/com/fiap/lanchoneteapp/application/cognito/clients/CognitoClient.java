package com.fiap.lanchoneteapp.application.cognito.clients;

import com.fiap.lanchoneteapp.infrastructure.cognito.clients.dto.GetUserResponse;

public interface CognitoClient {

    public GetUserResponse getUser(String token);

}
