package com.ext.ai.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class JokeClient {

    @Autowired
    private ChatClient chatClient;

    public String getJoke(String query){
        return chatClient.prompt(new Prompt(query)).call().content().trim();
    }

}
