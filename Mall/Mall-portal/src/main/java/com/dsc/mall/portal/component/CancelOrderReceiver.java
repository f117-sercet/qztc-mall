package com.dsc.mall.portal.component;

import com.dsc.mall.portal.servcie.OmsPortalOrderServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单信息的消费者
 * @author 60221
 */
@Component
@RabbitListener(queues ="mall.order.cancel" )
public class CancelOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderServcie portalOrderService;
    @RabbitHandler
    public void handle(Long orderId){
        portalOrderService.cancelOrder(orderId);
        LOGGER.info("process orderId:{}",orderId);
    }


}
