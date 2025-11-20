package com.info.sam.service.builder.strategy;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.request.yyy.YYYRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.bo.response.yyy.YYYResponseBO;
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
public class YYYBuilder implements IBuilder<YYYRequestBO, YYYResponseBO> {

   private AppLogger logger;
   private DataTransformerFactory dataTransformerFactory;

   @Override
    public YYYResponseBO build(YYYRequestBO build) {
        return new YYYResponseBO();
    }
}
