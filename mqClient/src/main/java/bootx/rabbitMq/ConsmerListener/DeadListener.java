package bootx.rabbitMq.ConsmerListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

import static bootx.rabbitMq.ConsmerListener.confirmConfig.MyAckReceiver.mapStringToMap;

@Slf4j
@Component
public class DeadListener {


    @RabbitListener(queues = "sixinQueue")
    public void dead(Map testMessage, Message message) {

        //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
        String msg = message.toString();
        String[] msgArray = msg.split("'");//可以点进Message里面看源码,单引号直接的数据就是我们的map消息数据
        Map<String, String> msgMap = mapStringToMap(msgArray[1].trim());
        String messageId = msgMap.get("messageId");
        String messageData = msgMap.get("messageData");
        String createTime = msgMap.get("createTime");
        System.out.println("死信释放" + message.getMessageProperties().getDeliveryTag());
        System.out.println("消费的消息来自的队列名为：" + message.getMessageProperties().getConsumerQueue());
        System.out.println("消息成功消费到  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
        System.out.println("执行  死信  业务处理流程......");
    }
}
