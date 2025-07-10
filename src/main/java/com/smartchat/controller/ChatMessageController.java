package com.smartchat.controller;

import com.smartchat.dto.ChatCompletionRequest;
import com.smartchat.dto.ChatCompletionResponse;
import com.smartchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    private final ChatService chatService;

    @Autowired
    public ChatMessageController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Mono<ChatCompletionResponse> ask(@RequestBody ChatCompletionRequest request) {
        return chatService.sendMessage(request);
    }
}
