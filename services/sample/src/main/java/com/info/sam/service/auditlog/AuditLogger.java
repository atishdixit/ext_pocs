package com.info.sam.service.auditlog;

import org.aspectj.lang.JoinPoint;

public interface AuditLogger {
    void log(JoinPoint joinPoint);
}
