package com.ricemarch.patternspring.pay.strategyEnum;

public enum StrategyEnum {
    ZfbPayStrategy("com.ricemarch.patternspring.pay.strategy.ZfbPayStrategy"),

    WcPayStrategy("com.ricemarch.patternspring.pay.strategy.WcPayStrategy"),

    BkPayStrategy("com.ricemarch.patternspring.pay.strategy.BkPayStrategy");

    String value = "";

    public String getValue() {
        return value;
    }

    StrategyEnum(String value) {
        this.value = value;
    }
}
