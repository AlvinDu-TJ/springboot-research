package sl.springboot.executor;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sl.springboot.executor.service.ConsumerService;
import sl.springboot.executor.service.Hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ExecutorApplication {
    public static void main(String[] args) {
        ApplicationContext c = SpringApplication.run(ExecutorApplication.class, args);

        Hello h = c.getBean(Hello.class);
        for (int i = 1; i <=100; i++) {
            sync(h, i+"");
        }
    }

    public CommandLineRunner buyPhone(ConsumerService service) throws Exception {
        return args -> {
            for (int i = 0; i <100; i++) {
               service.buyPhone(i+"");
               LoggerFactory.getLogger(ExecutorApplication.class).info("request id is " + i);
            }
        };
    }

    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            String quote = restTemplate.getForObject(
                    "https://www.baidu.com", String.class);
            String xmString = new String(quote.toString().getBytes("UTF-8"));
            LoggerFactory.getLogger(ExecutorApplication.class).info(xmString);
        };
    }

    private static void sync(Hello h, String name){
        h.sayHello(name);
    }


    private static void syncResult(Hello h){
        try {
            String alvin = h.sayHelloFuture("Alvin").get(1, TimeUnit.SECONDS);
            System.out.println("name is " + alvin);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
