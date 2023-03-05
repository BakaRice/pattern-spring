package com.ricemarch.patternspring.order;

import com.ricemarch.patternspring.order.pojo.Order;
import com.ricemarch.patternspring.order.pojo.OrderState;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListener {

    @OnTransition(source = "ORDER_WAIT_PAY", target = "ORDER_WAIT_SEND")
    public boolean payToSend(Message<OrderState> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_SEND);
        return true;
    }

    @OnTransition(source = "ORDER_WAIT_SEND", target = "ORDER_WAIT_RECEIVE")
    public boolean sendToReceive(Message<OrderState> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_WAIT_RECEIVE);
        return true;
    }

    @OnTransition(source = "ORDER_WAIT_RECEIVE", target = "ORDER_FINISH")
    public boolean receiveToFinish(Message<OrderState> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderState(OrderState.ORDER_FINISH);
        return true;
    }

}
