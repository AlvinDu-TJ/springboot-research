package sl.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sl.springboot.redis.util.RedisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sf  = new SimpleDateFormat("yyyyMMdd");
        String today = sf.format(new Date());


        Runnable rr = () -> redisUtil.incr(today, 1);

        for(int i=0;i<100;i++){
            new Thread(rr).start();
        }

    }
}
