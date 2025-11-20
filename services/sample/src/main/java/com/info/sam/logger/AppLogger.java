package com.info.sam.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AppLogger {

    private final LocationAwareLogger logger;
    private static final String CLASS_NAME=AppLogger.class.getName();

    public AppLogger() {
        String callerClassName = Thread.currentThread().getStackTrace()[3].getClassName();
        this.logger = (LocationAwareLogger) LoggerFactory.getLogger(callerClassName);
    }

    public void info(String message){
        log(message, LocationAwareLogger.INFO_INT);
    }

    public void info(String message, Object... arguments){
        log(message, LocationAwareLogger.INFO_INT, arguments);
    }

    public void debug(String message){
        log(message, LocationAwareLogger.DEBUG_INT);
    }

    public void debug(String message, Object... arguments){
        log(message, LocationAwareLogger.DEBUG_INT, arguments);
    }


    public void error(String message){
        log(message, LocationAwareLogger.ERROR_INT);
    }

    public void error(String message, Object... arguments){
        log(message, LocationAwareLogger.ERROR_INT, arguments);
    }

    public void warn(String message){
        log(message, LocationAwareLogger.WARN_INT);
    }

    public void warn(String message, Object... arguments){
        log(message, LocationAwareLogger.WARN_INT, arguments);
    }

    private void log(String message, int level){
        log(message, level, null);
    }

    private void log(String message, int level, Object[] argArray){
        logger.log(null, CLASS_NAME, level, message, argArray, null);
    }
}
