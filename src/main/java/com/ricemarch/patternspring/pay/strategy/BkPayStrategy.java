package com.ricemarch.patternspring.pay.strategy;


import com.ricemarch.patternspring.pay.pojo.PayBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BkPayStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        log.info("BkPayStrategy:{}", payBody.toString());
        return true;
    }
}
