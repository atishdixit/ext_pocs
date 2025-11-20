package com.info.sam.exception;

public class ServiceException extends SampleException{
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
