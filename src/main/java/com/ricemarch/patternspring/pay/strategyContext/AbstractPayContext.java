package com.ricemarch.patternspring.pay.strategyContext;


import com.ricemarch.patternspring.pay.pojo.PayBody;

public abstract class AbstractPayContext {
    public abstract Boolean execute(PayBody payBody);
}
