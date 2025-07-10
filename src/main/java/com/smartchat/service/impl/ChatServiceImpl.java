package com.smartchat.service.impl;

import com.smartchat.dto.ChatCompletionRequest;
import com.smartchat.dto.ChatCompletionResponse;
import com.smartchat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public ChatServiceImpl(@Value("${openai.api.key}") String apiKey) {
        this.apiKey = apiKey;

        // Configure WebClient with OpenRouter base URL and headers
        this.webClient = WebClient.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader("HTTP-Referer", "https://yourdomain.com") // Optional
                .defaultHeader("X-Title", "SmartChat") // Optional
                .build();
    }

    @Override
    public Mono<ChatCompletionResponse> sendMessage(ChatCompletionRequest request) {
        // Ensure model is set if not provided
        if (request.getModel() == null) {
            request.setModel("mistralai/mistral-7b-instruct");
        }

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatCompletionResponse.class)
                .doOnNext(response -> log.info("✅ Parsed response: {}", response))
                .doOnError(error -> log.error("❌ Error while calling OpenRouter", error));
    }
}
