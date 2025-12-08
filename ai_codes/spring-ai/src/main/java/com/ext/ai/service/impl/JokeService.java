package com.ext.ai.service.impl;

import com.ext.ai.client.JokeClient;
import com.ext.ai.service.infc.JokeServiceInfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeService implements JokeServiceInfc {

    @Autowired
    private JokeClient jokeClient;

    @Override
    public String getJoke(String query) {
        return jokeClient.getJoke(query);
    }
}
