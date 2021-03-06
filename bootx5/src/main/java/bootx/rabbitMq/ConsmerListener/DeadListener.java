package bootx.rabbitMq.ConsmerListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class DeadListener {


    @RabbitListener(queues = "sixinQueue")
    public void dead(Map testMessage, Message message) {

        System.out.println("死信释放" + message.getMessageProperties().getDeliveryTag());
    }
}
