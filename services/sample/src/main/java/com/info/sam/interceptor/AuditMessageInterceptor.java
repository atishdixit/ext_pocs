package com.info.sam.interceptor;

import com.info.sam.logger.AppLogger;
import com.info.sam.util.RequestUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class AuditMessageInterceptor implements ClientHttpRequestInterceptor {

    private final RequestUtil requestUtil;
    private final AppLogger logger;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        //TO-DO read the request and updatr
        logger.info("AuditMessageInterceptor Called-->");

        return execution.execute(request, body);
    }
}
