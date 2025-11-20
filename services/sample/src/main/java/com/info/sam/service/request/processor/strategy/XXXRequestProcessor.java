package com.info.sam.service.request.processor.strategy;

import com.info.sam.logger.AppLogger;
import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.service.translator.factory.SchemaTranslatorFactory;
import com.info.sam.service.translator.strategy.ISchemaTranslator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class XXXRequestProcessor implements IProcessor<XXXRequestBO,XXXResponseBO>{

    private AppLogger logger;
    private SchemaTranslatorFactory schemaTranslatorFactory;

    @Override
    public XXXResponseBO processRequest(XXXRequestBO data) {
        logger.info("Started : processRequest");
        ISchemaTranslator<XXXRequestBO, XXXResponseBO> iSchemaTranslator = schemaTranslatorFactory.getPolicySchemaTranslator();
        iSchemaTranslator.translate(null);
        return new XXXResponseBO();
    }
}
