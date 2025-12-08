package com.ext.ai.controller;

import com.ext.ai.model.AppStatus;
import com.ext.ai.service.infc.GenerativeServiceInfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gen-ai")
public class GenerativeApiController {

    @Autowired
    private GenerativeServiceInfc generativeServiceInfc;

    @GetMapping("/status")
    public AppStatus checkStatus(){
        return new AppStatus(200, "Service Up");
    }

    @GetMapping("/get-topic")
    public String getTopic(@RequestParam(value = "topic", defaultValue = "Give me good joke on Software developer") String topic){
     return generativeServiceInfc.generateResult(topic);
    }
}
