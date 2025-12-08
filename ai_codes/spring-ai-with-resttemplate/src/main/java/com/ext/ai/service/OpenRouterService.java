package com.ext.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ext.ai.dto.OpenRouterRequest;
import com.ext.ai.dto.OpenRouterResponse;

import java.util.List;

@Service
public class OpenRouterService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String askAI(String prompt) {

        OpenRouterRequest request = new OpenRouterRequest(
                "openai/gpt-oss-20b:free",
                List.of(new OpenRouterRequest.Message("user", prompt)),
                new OpenRouterRequest.Reasoning(true)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);	
        headers.setBearerAuth(apiKey);

        HttpEntity<OpenRouterRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<OpenRouterResponse> response =
                restTemplate.exchange(apiUrl, HttpMethod.POST, entity, OpenRouterResponse.class);

        return response.getBody()
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}