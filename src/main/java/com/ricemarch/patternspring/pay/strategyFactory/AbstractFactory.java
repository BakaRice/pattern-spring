package com.ricemarch.patternspring.pay.strategyFactory;

import com.ricemarch.patternspring.pay.strategy.PayStrategy;
import com.ricemarch.patternspring.pay.strategyEnum.StrategyEnum;

public abstract class AbstractFactory {

    abstract PayStrategy getPayStrategy(StrategyEnum strategyEnum);
}
