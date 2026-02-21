package com.felipe.dev.api.infra.AI.parsing;


import com.felipe.dev.api.application.gateways.AI.TriageAIResponse;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class StrictJsonParser {

    private final tools.jackson.databind.ObjectMapper mapper = new ObjectMapper();

    public record ParsedTriage(TriageAIResponse.Urgency urgency, String specialty, String reason) {}
    public record ParsedSummary(String summaryText) {}

    public ParsedTriage parseTriage(String raw) {
        try {
            String cleaned = cleanMarkdown(raw);
            tools.jackson.databind.JsonNode node = mapper.readTree(cleaned);
            String urgencyRaw = required(node, "urgency");
            String specialty = required(node, "specialty");
            String reason = required(node, "reason");

            TriageAIResponse.Urgency urgency = TriageAIResponse.Urgency.valueOf(urgencyRaw.trim().toUpperCase());

            return new ParsedTriage(urgency, specialty.trim(), reason.trim());
        } catch (Exception e) {
            throw new AIException("Invalid AI triage JSON", e);
        }
    }

    public ParsedSummary parseSummary(String raw) {
        try {
            String cleaned = cleanMarkdown(raw);
            JsonNode node = mapper.readTree(cleaned);
            String text = required(node, "summaryText");
            return new ParsedSummary(text.trim());
        } catch (Exception e) {
            throw new AIException("Invalid AI summary JSON", e);
        }
    }

    private String required(JsonNode node, String field) {
        JsonNode v = node.get(field);
        if (v == null || v.isNull()) {
            throw new IllegalArgumentException("Missing field: " + field);
        }
        String text = v.textValue();
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Missing field: " + field);
        }
        return text;
    }

    private String cleanMarkdown(String raw) {
        String cleaned = raw.trim();
        if (cleaned.startsWith("```")) {
            cleaned = cleaned.substring(3);
            if (cleaned.startsWith("json")) {
                cleaned = cleaned.substring(4);
            }
            int end = cleaned.lastIndexOf("```");
            if (end > 0) {
                cleaned = cleaned.substring(0, end);
            }
        }
        return cleaned.trim();
    }
}