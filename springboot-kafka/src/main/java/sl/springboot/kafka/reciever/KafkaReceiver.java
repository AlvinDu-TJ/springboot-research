package sl.springboot.kafka.reciever;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"hello"})
    public void listen(ConsumerRecord<?, ?> record, Acknowledgment ack) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
        // 提交偏移量
        ack.acknowledge();

    }

}
