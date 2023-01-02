package com.ricemarch.patternspring.pay.strategy;

import com.ricemarch.patternspring.pay.pojo.PayBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class WcPayStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        log.info("WcPayStrategy:{}", payBody.toString());
        return true;
    }
}
