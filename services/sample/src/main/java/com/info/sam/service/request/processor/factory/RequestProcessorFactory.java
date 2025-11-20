package com.info.sam.service.request.processor.factory;

import com.info.sam.logger.AppLogger;
import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.request.yyy.YYYRequestBO;
import com.info.sam.bo.request.zzz.ZZZRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.bo.response.yyy.YYYResponseBO;
import com.info.sam.bo.response.zzz.ZZZResponseBO;
import com.info.sam.service.request.processor.strategy.IProcessor;
import com.info.sam.service.request.processor.strategy.XXXRequestProcessor;
import com.info.sam.service.request.processor.strategy.YYYRequestProcessor;
import com.info.sam.service.request.processor.strategy.ZZZRequestProcessor;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RequestProcessorFactory {

    private AppLogger logger;
    private ApplicationContext applicationContext;

    public IProcessor<XXXRequestBO, XXXResponseBO> getXXXRequestProcessor(){
        logger.info("Started : getXXXRequestProcessor");
        return applicationContext.getBean(XXXRequestProcessor.class);
    }

    public IProcessor<YYYRequestBO, YYYResponseBO> getYYYRequestProcessor(){
        return applicationContext.getBean(YYYRequestProcessor.class);
    }

    public IProcessor<ZZZRequestBO, ZZZResponseBO> getZZZRequestProcessor(){
        return applicationContext.getBean(ZZZRequestProcessor.class);
    }
}
