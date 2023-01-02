package com.ricemarch.patternspring.service;


import com.ricemarch.patternspring.pay.facade.StrategyFacade;
import com.ricemarch.patternspring.pay.pojo.PayBody;

public class PayService {

    public Boolean pay(PayBody payBody) {
        boolean flag = false;
        flag = StrategyFacade.pay(payBody);
        if (flag) {
            saveToDb(payBody);
        }
        return flag;
    }

    private void saveToDb(PayBody payBody) {

    }
}
