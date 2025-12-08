package com.ext.ai.exception;

public class AiException extends RuntimeException{
    protected Integer statusCode;
    protected String description;

    public AiException(String message, Integer statusCode, String description) {
        super(message);
        this.statusCode = statusCode;
        this.description = description;
    }
}
