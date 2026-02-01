package com.felipe.dev.api.infra.AI.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai")
public record AIProperties(

        @Value("${api.provider}")
        String provider,

        @Value("${api.url}")
        String baseUrl,

        @Value("${api.secret}")
        String apiKey,

        @Value("${api.model}")
        String model,

        @Value("${api.timeoutms}")
        int timeoutMs,

        @Value("${max.retries}")
        int maxRetries
) {}