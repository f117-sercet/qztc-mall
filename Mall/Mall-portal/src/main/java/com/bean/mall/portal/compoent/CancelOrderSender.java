package com.bean.mall.portal.compoent;

import com.bean.mall.portal.domain.QueueEnum;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**-
 * 取消订单的消息发出者
 */
public class CancelOrderSender {
    private static Logger LoGGER= LoggerFactory.getLogger(CancelOrderSender.class);
    private AmqpTemplate amqpTemplate;
    public void sendMessage(Long orderId,final long delayTimes){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), orderId, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
        LoGGER.info("send orderId:{}",orderId);
    }

}
