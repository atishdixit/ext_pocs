package com.info.sam.service.request.processor.strategy;

import com.info.sam.logger.AppLogger;
import com.info.sam.bo.request.zzz.ZZZRequestBO;
import com.info.sam.bo.response.zzz.ZZZResponseBO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class ZZZRequestProcessor implements IProcessor<ZZZRequestBO, ZZZResponseBO> {

    private AppLogger logger;

    @Override
    public ZZZResponseBO processRequest(ZZZRequestBO data) {
        return new ZZZResponseBO();
    }
}
