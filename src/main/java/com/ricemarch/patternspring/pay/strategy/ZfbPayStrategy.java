package com.ricemarch.patternspring.pay.strategy;

import com.ricemarch.patternspring.pay.pojo.PayBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class ZfbPayStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        // 支付细节省略

        // 想在这里添加，被否定了，因为修改了pay的主逻辑。


        log.info("ZfbPayStrategy:{}", payBody.toString());
        return true;
    }
}
