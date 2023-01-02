package com.ricemarch.patternspring.controller;

import com.ricemarch.patternspring.pay.pojo.PayBody;
import com.ricemarch.patternspring.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    public PayService payService;

    @PostMapping("/pay")
    public Boolean pay(@RequestBody PayBody payBody) {
        return payService.pay(payBody);
    }
}
