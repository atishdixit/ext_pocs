package com.ext.ai.controller;

import com.ext.ai.service.infc.JokeServiceInfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    @Autowired
    private JokeServiceInfc jokeServiceInfc;

    @GetMapping("/bad")
    public String getBadJoke(@RequestParam(value = "message", defaultValue = "Provide mm a bad joke" ) String message){
        return jokeServiceInfc.getJoke(message);
    }

}
