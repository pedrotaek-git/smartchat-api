package com.smartchat.controller;

import com.smartchat.dto.ChatCompletionRequest;
import com.smartchat.dto.ChatCompletionResponse;
import com.smartchat.service.ChatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

@WebFluxTest(ChatMessageController.class)
public class ChatMessageControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ChatService chatService;

    @Test
    void testAsk() {
        // Creates the request with model, messages, and temperature
        ChatCompletionRequest request = new ChatCompletionRequest(
                "mistralai/mixtral-8x7b", // ✅ Modelo válido do OpenRouter
                List.of(new ChatCompletionRequest.Message("user", "Hello, who are you?")),
                0.7
        );

        // Creates the mocked response
        ChatCompletionResponse response = new ChatCompletionResponse();
        ChatCompletionResponse.Choice choice = new ChatCompletionResponse.Choice();
        choice.setIndex(0);
        choice.setMessage(new ChatCompletionRequest.Message("assistant", "Hi!"));
        response.setChoices(List.of(choice));

        // Mocks the behavior of ChatService
        Mockito.when(chatService.sendMessage(Mockito.any()))
                .thenReturn(Mono.just(response));

        // Executes the request and validates the response
        webTestClient.post()
                .uri("/api/chat")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.choices[0].message.content").isEqualTo("Hi!");
    }
}
