package com.info.sam.exception;

public class RecordNotFoundException extends SampleException{
    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }
}
