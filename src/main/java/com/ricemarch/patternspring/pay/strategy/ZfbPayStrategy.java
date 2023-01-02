package com.ricemarch.patternspring.pay.strategy;

import com.ricemarch.patternspring.pay.pojo.PayBody;

public class ZfbPayStrategy implements PayStrategy {
    @Override
    public Boolean pay(PayBody payBody) {
        // 支付细节省略

        // 想在这里添加，被否定了，因为修改了pay的主逻辑。


        return true;
    }
}
