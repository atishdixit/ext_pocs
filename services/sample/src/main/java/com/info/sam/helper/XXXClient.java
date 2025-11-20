package com.info.sam.helper;

import com.info.sam.logger.AppLogger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class XXXClient {
    private AppLogger logger;
    private RestTemplate  restTemplate;

    //Defined client end point
}
