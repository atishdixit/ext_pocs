package com.info.sam.service.transformer.factory;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.transformer.strategy.DataTransformer;
import com.info.sam.service.transformer.strategy.ITransformer;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataTransformerFactory {
    private AppLogger logger;
    private ApplicationContext applicationContext;

    public ITransformer<XXXRequestBO, XXXResponseBO> getDataTransformer(){
        logger.info("Started : getDataTransformer");
        return applicationContext.getBean(DataTransformer.class);
    }
}
