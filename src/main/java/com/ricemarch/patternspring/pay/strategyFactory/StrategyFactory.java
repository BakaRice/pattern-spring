package com.ricemarch.patternspring.pay.strategyFactory;


import com.ricemarch.patternspring.pay.strategy.PayStrategy;
import com.ricemarch.patternspring.pay.strategyEnum.StrategyEnum;


//我们的工厂类 依靠策略枚举返回策略类
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
