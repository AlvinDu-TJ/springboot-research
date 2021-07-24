package sl.springboot.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sl.springboot.rabbitmq.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void mqSendTest(){
//        Message message = new Message();
//        rabbitTemplate.send("exchange.direct","atguigu",message);

        Map<String, Object> map = new HashMap<>();
        map.put("msg","第一个消息");
        map.put("data", Arrays.asList("helloword", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
    }

    @Test
    public void mqSendTest2(){
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("三国演义","罗贯中"));
    }

    @Test
    public void mqReceiveTest(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
