package com.info.sam.util;

import com.info.sam.logger.AppLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RequestUtil {

    private AppLogger logger;
    private HttpServletRequest request;

    public String getRequestHeader(String headerName){
        String headerValue = null;
        try{
            headerValue = request.getHeader(headerName);
        }catch (Exception exception){
            logger.error("Failed to load {} from request header ", headerName, exception);
        }
        return headerValue;
    }


    public Object getRequestAttribute(String attributeName){
        Object headerValue = null;
        try{
            headerValue = request.getAttribute(attributeName);
        }catch (Exception exception){
            logger.error("Failed to load {} from request attribute ", attributeName, exception);
        }
        return headerValue;
    }

    public void setRequestAttribute(String attributeName, Object attributeValue){
        try{
        request.setAttribute(attributeName, attributeValue);
        }catch (Exception exception){
            logger.error("Failed to set {} into request attribute ", attributeName, exception);
        }
    }

    public String getRemoteAddress() {
        return request.getRemoteAddr();
    }
}
