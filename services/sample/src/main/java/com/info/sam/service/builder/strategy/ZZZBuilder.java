package com.info.sam.service.builder.strategy;

import com.info.sam.bo.request.zzz.ZZZRequestBO;
import com.info.sam.bo.response.zzz.ZZZResponseBO;
import com.info.sam.logger.AppLogger;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class ZZZBuilder implements IBuilder<ZZZRequestBO, ZZZResponseBO> {

    private AppLogger logger;

    @Override
    public ZZZResponseBO build(ZZZRequestBO build) {
        return new ZZZResponseBO();
    }
}
