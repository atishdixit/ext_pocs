package com.info.sam.service.translator.factory;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.translator.strategy.ISchemaTranslator;
import com.info.sam.service.translator.strategy.PolicySchemaTranslator;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SchemaTranslatorFactory {

    private AppLogger logger;
    private ApplicationContext applicationContext;

    public ISchemaTranslator<XXXRequestBO, XXXResponseBO> getPolicySchemaTranslator(){
        logger.info("Started : getPolicySchemaTranslator");
        return applicationContext.getBean(PolicySchemaTranslator.class);
    }
}
