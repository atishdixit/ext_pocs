package com.info.sam.service.translator.strategy;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.builder.factory.BuilderFactory;
import com.info.sam.service.builder.strategy.IBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class PolicySchemaTranslator implements ISchemaTranslator<XXXRequestBO, XXXResponseBO>{

    private AppLogger logger;
    private BuilderFactory builderFactory;

    @Override
    public XXXResponseBO translate(XXXRequestBO data) {
        logger.info("Started : translate");
        IBuilder<XXXRequestBO, XXXResponseBO>  builder = builderFactory.getXXXBuilder();
        builder.build(null);
        return new XXXResponseBO();
    }
}
