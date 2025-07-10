package com.smartchat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ChatMessageResponse {
    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
