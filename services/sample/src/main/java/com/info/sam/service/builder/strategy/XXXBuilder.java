package com.info.sam.service.builder.strategy;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.transformer.factory.DataTransformerFactory;
import com.info.sam.service.transformer.strategy.ITransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class XXXBuilder implements IBuilder<XXXRequestBO, XXXResponseBO>{

    private AppLogger logger;
    private DataTransformerFactory dataTransformerFactory;

    @Override
    public XXXResponseBO build(XXXRequestBO build) {
        logger.info("Started : build");
        ITransformer<XXXRequestBO, XXXResponseBO> transformer = dataTransformerFactory.getDataTransformer();
        transformer.transform(null);
        return new XXXResponseBO();
    }
}
