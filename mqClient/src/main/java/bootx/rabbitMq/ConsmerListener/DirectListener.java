package bootx.rabbitMq.ConsmerListener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class DirectListener {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "TestDirectQueue")
    public void process(Map testMessage, Message Message, Channel channel) throws IOException {
        try {
            int a = 1 / 0;//判断条件  以触发死信
            System.out.println("DirectQueue  : " + testMessage.toString());
            channel.basicAck(Message.getMessageProperties().getDeliveryTag(), false);//放最后
        } catch (Exception e) {
            /**
             * deliveryTag:消息的index
             * multiple：是否批量.true:将一次性  拒绝/确认  所有小于deliveryTag的消息。
             * requeue：被拒绝的是否重新入队列 ,被拒绝的是否重新入队列，重新入列会造成   “死循环”
             * 出错了，发nack，并通知MQ把消息塞回的队列头部（不是尾部）
             */
            //********========================>>>>>>>>>>>>>>>>>>>
            /**
             * channel.basicReject(deliveryTag, true);
             * basic.reject方法拒绝deliveryTag对应的消息，
             * 第二个参数是否requeue，true则重新入队列，否则丢弃或者进入死信队列。
             *
             * 该方法reject后，该消费者还是会消费到该条被reject的消息。
             *
             * channel.basicNack(deliveryTag, false, true);
             * basic.nack方法为不确认deliveryTag对应的消息，第二个参数是否应用于多消息，
             * 第三个参数是否requeue，与basic.reject区别就是同时支持多个消息，
             * 可以nack该消费者先前接收未ack的所有消息。nack后的消息也会被自己消费到。
             *
             * channel.basicRecover(true);
             * basic.recover是否恢复消息到队列，参数是是否requeue，true则重新入队列，
             * 并且尽可能的将之前recover的消息投递给其他消费者消费，
             * 而不是自己再次消费。false则消息会重新被投递给自己。
             *
             * basicNack 方法与 basicReject 方法区别在于basicNack可以批量拒绝多条消息，而basicReject一次只能拒绝一条消息。
             * ***千万不要重复入列  死循环  ***
             */
            //channel.basicReject(Message.getMessageProperties().getDeliveryTag(), true);
            //channel.basicRecover(false);
            //channel.basicAck(Message.getMessageProperties().getDeliveryTag(), false);//放最后
            //channel.basicNack(Message.getMessageProperties().getDeliveryTag(), false, true);
            //rabbitTemplate.convertAndSend("sixinExchange", "sixin", testMessage);
            log.info(Message.getMessageProperties().getDeliveryTag() + ":进入死信队列.........");
        }
    }

}