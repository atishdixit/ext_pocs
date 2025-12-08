package com.ext.ai.utils;

import com.ext.ai.model.BaseDTO;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.ai.converter.StructuredOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OutputConverter {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    public StructuredOutputConverter getOutputConverter(Converter converter){
//        return (StructuredOutputConverter)applicationContext.getBean(converter.name());
//    }
//
//    public <T extends BaseDTO> StructuredOutputConverter<T> getBeanOutputConverter(Class<T> clazz){
//        return new BeanOutputConverter<T>(clazz);
//    }

    @Autowired
    private ListOutputConverter converter;

    @Autowired
    private MapOutputConverter mapOutputConverter;

    public OutputConverter outputConverter(Converter converter){
        return this;
    }
    
    public String getFormat(){
        return converter.getFormat();
    }




}
