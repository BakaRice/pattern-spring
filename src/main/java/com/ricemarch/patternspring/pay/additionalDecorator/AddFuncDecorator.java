package com.ricemarch.patternspring.pay.additionalDecorator;


import com.ricemarch.patternspring.pay.pojo.PayBody;
import com.ricemarch.patternspring.pay.strategyContext.AbstractPayContext;

public class AddFuncDecorator extends AbstractAddFuncDecorator {

    public AddFuncDecorator(AbstractPayContext abstractPayContext) {
        super(abstractPayContext);
    }


    // 新活
    @Override
    public void additionalFunction(PayBody payBody) {

        String product = payBody.getProduct();

        // 从db里面获取 product的详情信息
        // 从配置中心（redis缓存）里获取产品的更新策略
        // 根据策略更新用户平台币 或发放红包
        System.out.println("更新平台币成功，发送红包到用户优惠券模块成功。");
    }

    // 新活 老活 的逻辑组装
    @Override
    public Boolean execute(PayBody payBody) {
        Boolean result = super.execute(payBody);// 老活
        this.additionalFunction(payBody); // 新活 新活的各种重试，失败补偿
        return result;
    }
}
