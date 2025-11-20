package com.info.sam.service.translator.strategy;

public interface ISchemaTranslator<T, R> {
    R translate(T data);
}
