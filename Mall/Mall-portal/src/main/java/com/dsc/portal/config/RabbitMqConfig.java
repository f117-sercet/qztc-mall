package com.dsc.portal.config;

import com.dsc.portal.domain.QueueEnum;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:estic
 * @Date: 2021/2/25 23:30
 * 消息队列相关配置
 */
@Configuration
public class RabbitMqConfig {


    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange orderDirect(){
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }
}
