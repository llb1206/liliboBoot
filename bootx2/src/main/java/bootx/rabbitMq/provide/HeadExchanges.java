package bootx.rabbitMq.provide;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HeadExchanges {
	 @Bean
    public Queue headersQueue() {
        return new Queue("HEADERS_QUEUE");
    }
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("HEADERS_EXCHANGE");
    }
    //将headersQueue与HeadersExchange交换机绑定
    @Bean
    public Binding bingHeadersQueue() {
    	//map为绑定的规则
        Map<String, Object> map = new HashMap<>();
        map.put("headers1", "value1");
        map.put("headers2", "value2");
        //whereAll表示需要满足所有条件
        return BindingBuilder.bind(headersQueue()).to(headersExchange()).whereAll(map).match();
    }
}
