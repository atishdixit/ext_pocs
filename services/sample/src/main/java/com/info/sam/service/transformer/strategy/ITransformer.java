package com.info.sam.service.transformer.strategy;

public interface ITransformer <T, R>{
    R transform(R data);
}
