package com.ext.ai.config;

import com.ext.ai.utils.Converter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.ai.parser.ListOutputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class AppConfig {

    @Value("spring.ai.openai.chat.options.model")
    private String modal;

    @Autowired
    ChatModel chatModel;

    @Bean
    ChatClient chatClient(){
        return ChatClient.create(chatModel);
    }

    @Bean("listConverter")
    ListOutputConverter listOutputConverter(){
        return new ListOutputConverter(new DefaultConversionService());
    }

    @Bean("mapConverter")
    MapOutputConverter mapOutputConverter(){
        return new MapOutputConverter();
    }
}
