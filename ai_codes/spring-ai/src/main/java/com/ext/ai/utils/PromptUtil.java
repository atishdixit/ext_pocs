package com.ext.ai.utils;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;

import java.util.Map;

public final class PromptUtil {

    private PromptUtil(){}

    public static String prepareQuery(String query, String topic){
        return  String.format(query, topic);
    }

    public static Prompt preparePrompt(String template, Map<String, Object> param){
        PromptTemplate promptTemplate = new PromptTemplate(template, param);
        return promptTemplate.create();
    }
}
