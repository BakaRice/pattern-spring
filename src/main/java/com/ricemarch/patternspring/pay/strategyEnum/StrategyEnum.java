package com.ricemarch.patternspring.pay.strategyEnum;

public enum StrategyEnum {
    ZfbPayStrategy("com.ricemarch.patternspring.pay.strategy.ZfbPayStrategy"),

    WcPayStrategy("com.ricemarch.patternspring.pay.strategy.WcPayStrategy"),

    BkPayStrategy("com.ricemarch.patternspring.pay.strategy.BkPayStrategy");

    final String value;

    public String getValue() {
        return value;
    }

    StrategyEnum(String value) {
        this.value = value;
    }

    public static StrategyEnum getStrategyEnum(int type) {
        return switch (type) {
            case 0 -> StrategyEnum.ZfbPayStrategy;
            case 1 -> StrategyEnum.WcPayStrategy;
            case 2 -> StrategyEnum.BkPayStrategy;
            default -> null;
        };
    }
}
