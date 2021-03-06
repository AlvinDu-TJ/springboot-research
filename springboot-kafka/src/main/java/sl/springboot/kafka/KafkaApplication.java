package sl.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sl.springboot.kafka.sender.KafkaSender;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Autowired
    KafkaSender kafkaSender;

    @Override
    public void run(String... args) throws Exception {
        new Thread(()->{
            while(true) {
                kafkaSender.send(ThreadLocalRandom.current().nextLong(100L));
                try {
                    TimeUnit.SECONDS.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
