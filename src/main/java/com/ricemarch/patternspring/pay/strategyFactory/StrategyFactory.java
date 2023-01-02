package com.ricemarch.patternspring.pay.strategyFactory;


import com.ricemarch.patternspring.pay.strategy.PayStrategy;
import com.ricemarch.patternspring.pay.strategyEnum.StrategyEnum;

public class StrategyFactory {
    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum) {
        PayStrategy payStrategy = null;
        try {
            payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
        } catch (Exception e) {
            // 异常
        }
        return payStrategy;
    }
}
