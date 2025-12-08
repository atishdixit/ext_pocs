package com.ext.ai.controller;

import org.springframework.web.bind.annotation.*;

import com.ext.ai.service.OpenRouterService;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final OpenRouterService service;

    public AIController(OpenRouterService service) {
        this.service = service;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String q) {
        return service.askAI(q);
    }
}