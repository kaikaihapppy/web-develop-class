package com.example.demo;

import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterApplicationTests {
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void amqpAdmin() {
        //定义fanout类型的交换器
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));
        //定义两个默认持久化队列分别处理email和sms
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_sms"));
        //将队列分别与交换器进行绑定
        amqpAdmin.declareBinding(new Binding("fanout_queue_email",
                Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_sms",
                Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void pushPublisher() {
        User user = new User();
        user.setId(1);
        user.setUsername("石头");
        //第一个参数表示定义的交换器名称，第二个表示路由键，第三个表示消息内容
        rabbitTemplate.convertAndSend("fanout_exchange", "", user);
    }

    @Test
    public void routingPublisher() {
        rabbitTemplate.convertAndSend("routing_exchange", "error_routing_key","routing send error message");
    }

    @Test
    public void topicPublisher() {
        rabbitTemplate.convertAndSend("topic_exchange","info.email", "topics send email message");
        rabbitTemplate.convertAndSend("topic_exchange","info.sms", "topics send sms message");
        rabbitTemplate.convertAndSend("topic_exchange", "info.email.sms",
                "topics send email and sms message");}
}
