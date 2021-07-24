package sl.springboot.kafka.sender;

import com.google.common.base.Function;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import sl.springboot.kafka.bean.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(Long id) {
        Message message = new Message();
        message.setId(id);
        message.setMsg(UUID.randomUUID().toString());
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        message.setLocalDateTime(format);



        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("hello", gson.toJson(message));
    }

}
