package bootx.rabbitMq.ConsmerListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;


@Component
public class TopicListener {

    @RabbitListener(queues = "topic.man")
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = "topic.woman")
    public void processB(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }
}