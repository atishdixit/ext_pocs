package com.info.sam.aspects.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonPointCuts {

    @Pointcut("execution(* com.info.sam.controller.*.*(..))")
    public void restControllerMethod(){
    }
}
