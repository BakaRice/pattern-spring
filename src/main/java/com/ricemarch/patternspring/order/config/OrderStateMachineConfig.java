package com.ricemarch.patternspring.order.config;

import com.ricemarch.patternspring.order.pojo.Order;
import com.ricemarch.patternspring.order.pojo.OrderState;
import com.ricemarch.patternspring.order.pojo.OrderStateChangeAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderStateChangeAction> {
    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderStateChangeAction> states) throws Exception {
        //状态初始化
        states.withStates().initial(OrderState.ORDER_WAIT_PAY)
                .states(EnumSet.allOf(OrderState.class));

    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderStateChangeAction> transitions) throws Exception {
//        super.configure(transitions);
        transitions.withExternal().source(OrderState.ORDER_WAIT_PAY).target(OrderState.ORDER_WAIT_SEND).event(OrderStateChangeAction.ORDER_PAY)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_SEND).target(OrderState.ORDER_WAIT_RECEIVE).event(OrderStateChangeAction.ORDER_SEND)
                .and()
                .withExternal().source(OrderState.ORDER_WAIT_RECEIVE).target(OrderState.ORDER_FINISH).event(OrderStateChangeAction.ORDER_RECEIVE);
    }

    @Bean
    public DefaultStateMachinePersister<?, ?, ?> machinePersister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object, Object, Order>() {
            @Override
            public void write(StateMachineContext<Object, Object> stateMachineContext, Order o) throws Exception {
                //持久化操作，可以有任何的表现形式
            }

            @Override
            public StateMachineContext<Object, Object> read(Order o) throws Exception {
                return new DefaultStateMachineContext<>(o.getOrderState(), null, null, null);
            }
        });
    }
}
