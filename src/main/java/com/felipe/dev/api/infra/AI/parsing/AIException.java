package com.felipe.dev.api.infra.AI.parsing;

public class AIException extends RuntimeException {
    public AIException(String message) { super(message); }
    public AIException(String message, Throwable cause) { super(message, cause); }
}
