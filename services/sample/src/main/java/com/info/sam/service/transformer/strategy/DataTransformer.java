package com.info.sam.service.transformer.strategy;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.logger.AppLogger;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class DataTransformer implements ITransformer<XXXRequestBO, XXXResponseBO>{

    private AppLogger logger;

    @Override
    public XXXResponseBO transform(XXXResponseBO data) {
        logger.info("Started : getDataTransformer");
        return new XXXResponseBO();
    }
}
