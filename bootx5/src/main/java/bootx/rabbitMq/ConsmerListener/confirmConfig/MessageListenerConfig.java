//package bootx.rabbitMq.ConsmerListener.confirmConfig;
//
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 消费端确认消息  分为两种，这是其一，另一种是注解方式，配置这种方式以后，对应的注解方式失效，是全部失效哦
// * <p>
// * 说白了 这就是非注解的配置方式，可以使用应答机制等等
// */
//@Configuration
//public class MessageListenerConfig {
//
//    @Autowired
//    private CachingConnectionFactory connectionFactory;
//    @Autowired
//    private MyAckReceiver myAckReceiver;//消息接收处理类
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setConcurrentConsumers(1);
//        container.setMaxConcurrentConsumers(1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
//        //设置一个队列
//        //container.setQueueNames("fanout.A");
//        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
//        //container.setQueueNames("fanout.A","fanout.B","fanout.C");
//
//        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
//        //container.setQueues(new Queue("TestDirectQueue",true));
//        //container.addQueues(new Queue("TestDirectQueue2",true));
//        //container.addQueues(new Queue("TestDirectQueue3",true));
//        container.setMessageListener(myAckReceiver);
//
//        return container;
//    }
//
//
//}