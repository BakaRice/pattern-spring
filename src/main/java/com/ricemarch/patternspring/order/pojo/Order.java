package com.ricemarch.patternspring.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private Integer orderId;

    private OrderState orderState;
}
