package com.info.sam.service.request.processor.strategy;

import com.info.sam.logger.AppLogger;
import com.info.sam.bo.request.yyy.YYYRequestBO;
import com.info.sam.bo.response.yyy.YYYResponseBO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class YYYRequestProcessor implements IProcessor<YYYRequestBO, YYYResponseBO>{

    private AppLogger logger;

    @Override
    public YYYResponseBO processRequest(YYYRequestBO data) {
        return new YYYResponseBO();
    }
}
