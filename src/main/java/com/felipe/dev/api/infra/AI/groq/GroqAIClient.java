package com.felipe.dev.api.infra.AI.groq;

import com.felipe.dev.api.application.gateways.AI.*;
import com.felipe.dev.api.application.gateways.TriageRepository;
import com.felipe.dev.api.domain.entities.triage.Triage;
import com.felipe.dev.api.infra.AI.config.AIProperties;
import com.felipe.dev.api.infra.AI.fallback.SummaryFallbackPolicy;
import com.felipe.dev.api.infra.AI.fallback.TriageFallbackPolicy;
import com.felipe.dev.api.infra.AI.parsing.AIException;
import com.felipe.dev.api.infra.AI.parsing.StrictJsonParser;
import com.felipe.dev.api.infra.AI.prompts.PromptTemplates;
import com.felipe.dev.api.infra.AI.prompts.SummaryPromptBuilder;
import com.felipe.dev.api.infra.AI.prompts.TriagePromptBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class GroqAIClient implements AIClient {

    private final WebClient webClient;
    private final AIProperties props;

    private final TriageRepository triageRepository;

    private final TriagePromptBuilder triagePromptBuilder = new TriagePromptBuilder();
    private final SummaryPromptBuilder summaryPromptBuilder = new SummaryPromptBuilder();
    private final StrictJsonParser jsonParser = new StrictJsonParser();

    private final TriageFallbackPolicy triageFallback = new TriageFallbackPolicy();
    private final SummaryFallbackPolicy summaryFallback = new SummaryFallbackPolicy();

    public GroqAIClient(WebClient aiWebClient, AIProperties props, TriageRepository triageRepository) {
        this.triageRepository = triageRepository;
        this.webClient = aiWebClient;
        this.props = props;
    }

    @Override
    public TriageAIResponse triage(TriageAIRequest request, Long patientId) {
        String userPrompt = triagePromptBuilder.buildUserPrompt(request);

        long start = System.currentTimeMillis();
        try {
            String rawContent = callChat(PromptTemplates.TRIAGE_SYSTEM, userPrompt);
            
            System.out.println("🔍 RESPOSTA DA IA: " + rawContent);
            
            long latency = System.currentTimeMillis() - start;

            var parsed = jsonParser.parseTriage(rawContent);

            triageRepository.save(new Triage(
                    patientId,
                    parsed.urgency().name(),
                    parsed.specialty(),
                    parsed.reason()
            ));
            return new TriageAIResponse(
                    parsed.urgency(),
                    parsed.specialty(),
                    parsed.reason(),
                    new AITrace("groq", props.model(), userPrompt, rawContent, latency)
            );
        } catch (Exception ex) {
            return triageFallback.fallback(request, ex);
        }
    }

    @Override
    public SummaryAIResponse generateSummary(SummaryAIRequest request) {
        String userPrompt = summaryPromptBuilder.buildUserPrompt(request);

        long start = System.currentTimeMillis();
        try {
            String rawContent = callChat(PromptTemplates.SUMMARY_SYSTEM, userPrompt);
            long latency = System.currentTimeMillis() - start;

            var parsed = jsonParser.parseSummary(rawContent);

            return new SummaryAIResponse(
                    parsed.summaryText(),
                    new AITrace("groq", props.model(), userPrompt, rawContent, latency)
            );
        } catch (Exception ex) {
            return summaryFallback.fallback(request, ex);
        }
    }

    private String callChat(String systemPrompt, String userPrompt) {
        GroqChatRequest payload = new GroqChatRequest(
                props.model(),
                List.of(
                        new GroqChatRequest.Message("system", systemPrompt),
                        new GroqChatRequest.Message("user", userPrompt)
                ),
                0.2
        );


        GroqChatResponse resp = webClient.post()
                .uri("/chat/completions") // base-url já é .../openai/v1
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(GroqChatResponse.class)
                .timeout(Duration.ofMillis(props.timeoutMs()))
                .block();

        if (resp == null || resp.choices() == null || resp.choices().isEmpty()) {
            throw new AIException("Empty Groq response");
        }

        return resp.choices().get(0).message().content();
    }
}