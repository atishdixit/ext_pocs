package com.ext.ai.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongsClient {
    @Autowired
    private ListOutputConverter converter;

    @Autowired
    private ChatClient chatClient;

    public String call(Prompt prompt) {
        ChatResponse chatResponse = this.chatClient.prompt(prompt).call().chatResponse();
        return chatResponse.getResult().getOutput().getContent();
    }

//    public List<String> callAsJsonList(Prompt prompt) {
//        ChatResponse chatResponse = this.chatClient.prompt(prompt).call().chatResponse();
//        return converter.convert(chatResponse.getResult().getOutput().getContent();
//    }
}
