package sl.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sl.springboot.redis.util.RedisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ApplicationContext c = SpringApplication.run(RedisApplication.class, args);
        RedisUtil r = (RedisUtil) c.getBean("redisUtil");

        SimpleDateFormat sf  = new SimpleDateFormat("yyyyMMdd");
        String today = sf.format(new Date());


        Runnable rr = new Runnable(){

            @Override
            public void run() {
                r.incr(today, 1);
            }
        };

        for(int i=0;i<100;i++){
            new Thread(rr).start();
        }



    }
}
