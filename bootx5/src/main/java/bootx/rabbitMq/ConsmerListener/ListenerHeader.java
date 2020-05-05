package bootx.rabbitMq.ConsmerListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class ListenerHeader {
    @RabbitListener(queues = "HEADERS_QUEUE")
    public void receiveHeadersQueue(byte[] message) {
        log.info("receive : HeadersQueue {}", new String(message));
    }
}
