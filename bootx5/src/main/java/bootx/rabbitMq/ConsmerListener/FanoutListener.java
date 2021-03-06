package bootx.rabbitMq.ConsmerListener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class FanoutListener {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "fanout.A")
    public void process(Map str, Message testMessage, Channel channel) throws IOException {

        try {
            int a = 1 / 0;
            channel.basicAck(testMessage.getMessageProperties().getDeliveryTag(), false);
            System.out.println("FanoutReceiverA消费者收到消息  : " + testMessage.toString());
        } catch (Exception e) {
            //channel.basicReject(testMessage.getMessageProperties().getDeliveryTag(), false);
            channel.basicNack(testMessage.getMessageProperties().getDeliveryTag(), false, false);
            rabbitTemplate.convertAndSend("sixinExchange", "sixin", str);
        }
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(Map testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = "sixinQueue")
    public void processsixin(Map testMessage, Message message) {
        System.out.println("死信释放" + message.getMessageProperties().getDeliveryTag());
    }

    @RabbitListener(queues = "fanout.D")
    public void processsixind(Map testMessage) {
        System.out.println("死信释放");
    }
}