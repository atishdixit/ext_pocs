package com.info.sam.service.auditlog;

import com.info.sam.logger.AppLogger;
import com.info.sam.constant.AppConstant;
import com.info.sam.util.RequestUtil;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuditLoggerImpl implements AuditLogger {

    private AppLogger logger;
    private RequestUtil requestUtil;

    @Override
    public void log(JoinPoint joinPoint) {
        logger.debug("Started log method");
        Map<String, Object> requestHeader = readRequestHeader();
        logger.debug("Completed log method");

        //data write
    }

    private Map<String, Object> readRequestHeader() {
    Map<String, Object> headerDetails = new HashMap<>();
        headerDetails.put(AppConstant.REMOTE_IP_ADDRESS, requestUtil.getRequestHeader(AppConstant.X_FORWARDED_FOR)!=null?
                requestUtil.getRequestHeader(AppConstant.X_FORWARDED_FOR):requestUtil.getRemoteAddress());
    return headerDetails;
    }
}
