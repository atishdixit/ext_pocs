package com.info.sam.service.request.processor.strategy;

public interface IProcessor <T, R>{
    R processRequest(T data);
}
