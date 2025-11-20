package com.info.sam.service.builder.strategy;

public interface IBuilder<T, R> {
    R build(T build);
}
