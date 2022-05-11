package sl.springboot.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CachedThreadPoll {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int count = i;
            executorService.execute(()-> System.out.println("current run thread" + count + "thread name is" + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
