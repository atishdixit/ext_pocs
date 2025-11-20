package com.info.sam.controller;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.request.processor.factory.RequestProcessorFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/sample")
public class RequestController {

    private AppLogger logger;
    private RequestProcessorFactory requestProcessorFactory;

    @GetMapping(value = "/health-check", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getHealthStatus(){
        logger.info("Started: Health check end point...");
        requestProcessorFactory.getXXXRequestProcessor().processRequest(new XXXRequestBO());
        return ResponseEntity.status(HttpStatus.OK).body("Service Up...");
    }

    @GetMapping(value = "/secure", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> secureEndPoint(){
        logger.info("Started: Health check end point...");
        requestProcessorFactory.getXXXRequestProcessor().processRequest(new XXXRequestBO());
        return ResponseEntity.status(HttpStatus.OK).body("Secure End point...");
    }
}
