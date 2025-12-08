package com.ext.ai.utils;

public enum Converter {
    DEFAULT("text"),
    LIST("listConverter"),
    MAP("mapConverter"),
    BEAN("beanConverter");

    Converter(String type) {
        converterType = type;
    }

    private String value(){
        return converterType;
    }

    private String converterType;
}
