package com.felipe.dev.api.infra.AI.groq;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GroqChatRequest(
        String model,
        List<Message> messages,
        double temperature
) {
    public record Message(String role, String content) {}
}
