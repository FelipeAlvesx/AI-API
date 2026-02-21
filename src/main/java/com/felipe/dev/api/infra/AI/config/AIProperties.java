package com.felipe.dev.api.infra.AI.config;



import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai")
public record AIProperties(

        String provider,

        String baseUrl,

        String apiKey,

        String model,

        int timeoutMs,

        int maxRetries
) {}