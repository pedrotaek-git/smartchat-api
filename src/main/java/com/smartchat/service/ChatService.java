package com.smartchat.service;

import com.smartchat.dto.ChatCompletionRequest;
import com.smartchat.dto.ChatCompletionResponse;
import reactor.core.publisher.Mono;

public interface ChatService {
    Mono<ChatCompletionResponse> sendMessage(ChatCompletionRequest request);
}
