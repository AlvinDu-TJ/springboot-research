package sl.springboot.executor.service;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Hello {
    @Async
    public void sayHello(String name) {
        LoggerFactory.getLogger(Hello.class).info(name + ":Hello World!");
    }

    @Async
    public ListenableFuture<String> sayHelloFuture(String name) {
        String res = name + ":Hello World!";
        LoggerFactory.getLogger(Hello.class).info(res);
        return new AsyncResult<>(res);
    }
}
