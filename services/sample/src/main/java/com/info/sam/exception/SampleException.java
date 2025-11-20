package com.info.sam.exception;

public class SampleException extends RuntimeException{

    public SampleException(String message) {
        super(message);
    }

    public SampleException(Throwable cause) {
        super(cause);
    }
}
