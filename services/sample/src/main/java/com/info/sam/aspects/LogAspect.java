package com.info.sam.aspects;

import com.info.sam.logger.AppLogger;
import com.info.sam.service.auditlog.AuditLogger;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class LogAspect {

    private AppLogger appLogger;
    private AuditLogger auditLogger;

    @Before(value = "com.info.sam.aspects.pointcut.CommonPointCuts.restControllerMethod()")
    public void beforeExecutionRestController(JoinPoint joinPoint){
        appLogger.info("Before Execution Rest Controller");
        auditLogger.log(joinPoint);
    }


    @AfterThrowing(value = "com.info.sam.aspects.pointcut.CommonPointCuts.restControllerMethod()")
    public void afterThrowingExceptionRestController(JoinPoint joinPoint){
        appLogger.info("After Exception Rest Controller");
        auditLogger.log(joinPoint);
    }


    @After(value = "com.info.sam.aspects.pointcut.CommonPointCuts.restControllerMethod()")
    public void afterExecutionRestController(JoinPoint joinPoint){
        appLogger.info("After Execution Rest Controller");
        auditLogger.log(joinPoint);
    }
}
