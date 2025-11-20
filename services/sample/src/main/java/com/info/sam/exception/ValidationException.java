package com.info.sam.exception;

public class ValidationException extends SampleException{
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
