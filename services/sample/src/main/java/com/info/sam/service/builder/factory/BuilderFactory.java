package com.info.sam.service.builder.factory;

import com.info.sam.bo.request.xxx.XXXRequestBO;
import com.info.sam.bo.request.yyy.YYYRequestBO;
import com.info.sam.bo.request.zzz.ZZZRequestBO;
import com.info.sam.bo.response.xxx.XXXResponseBO;
import com.info.sam.bo.response.yyy.YYYResponseBO;
import com.info.sam.bo.response.zzz.ZZZResponseBO;
import com.info.sam.logger.AppLogger;
import com.info.sam.service.builder.strategy.IBuilder;
import com.info.sam.service.builder.strategy.XXXBuilder;
import com.info.sam.service.builder.strategy.YYYBuilder;
import com.info.sam.service.builder.strategy.ZZZBuilder;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BuilderFactory {

    private AppLogger logger;
    private ApplicationContext applicationContext;

    public IBuilder<XXXRequestBO, XXXResponseBO> getXXXBuilder(){
        logger.info("Started : getXXXBuilder");
        return applicationContext.getBean(XXXBuilder.class);
    }

    public IBuilder<YYYRequestBO, YYYResponseBO> getYYYBuilder(){
        return applicationContext.getBean(YYYBuilder.class);
    }

    public IBuilder<ZZZRequestBO, ZZZResponseBO> getZZZBuilder(){
        return applicationContext.getBean(ZZZBuilder.class);
    }
}
