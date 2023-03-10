package com.ricemarch.patternspring.pay.facade;


import com.ricemarch.patternspring.pay.additionalDecorator.AddFuncDecorator;
import com.ricemarch.patternspring.pay.pojo.PayBody;
import com.ricemarch.patternspring.pay.strategy.PayStrategy;
import com.ricemarch.patternspring.pay.strategyContext.PayContext;
import com.ricemarch.patternspring.pay.strategyEnum.StrategyEnum;
import com.ricemarch.patternspring.pay.strategyFactory.StrategyFactory;


//最终我们只暴露我们的门面，对于里面的这些所有的工厂，策略，策略枚举，全部不暴露。
//门面就是我们的超强封装
public class StrategyFacade {

    // 定义一个map 将对应关系提前初始化好。
    public static Boolean pay(PayBody payBody) {
        // 获取我们的 策略枚举
        StrategyEnum strategyEnum = StrategyEnum.getStrategyEnum(payBody.getType());
        if (strategyEnum == null) {
            return false;
        }
        // 获取我们的策略对象
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(strategyEnum);
        // 生成我们的策略上下文
        PayContext context = new PayContext(payStrategy);

        // 装饰一下context
        AddFuncDecorator addFuncDecorator = new AddFuncDecorator(context);

        // 进行扣款
        return addFuncDecorator.execute(payBody);
    }
}
