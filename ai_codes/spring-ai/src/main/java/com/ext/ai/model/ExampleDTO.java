package com.ext.ai.model;

public class ExampleDTO extends BaseDTO{
    private String name;

    public ExampleDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
