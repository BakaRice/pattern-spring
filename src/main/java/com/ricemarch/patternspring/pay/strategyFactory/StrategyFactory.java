package com.ricemarch.patternspring.pay.strategyFactory;


import com.ricemarch.patternspring.pay.strategy.PayStrategy;
import com.ricemarch.patternspring.pay.strategyEnum.StrategyEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


// 我们的工厂类 依靠策略枚举返回策略类
// 我们以后永远不需要修改我们的factory，他是一个无状态的
public class StrategyFactory {

    private static final Map<String, PayStrategy> STRATEGY_MAP = new ConcurrentHashMap<>();

    public static PayStrategy getPayStrategy(StrategyEnum strategyEnum) {
        PayStrategy payStrategy = STRATEGY_MAP.get(strategyEnum.getValue());
        if (payStrategy == null) {
            try {

                // 每次获取都需要进行一次反射。优化调整==> 单例模式
                payStrategy = (PayStrategy) Class.forName(strategyEnum.getValue()).newInstance();
                STRATEGY_MAP.put(strategyEnum.getValue(), payStrategy);
            } catch (Exception e) {
                // 异常
            }
        }
        return payStrategy;
    }


    // utils  是以功能导向的工具类
    // factory 是以产出为导向的，产出一类行为类
}
