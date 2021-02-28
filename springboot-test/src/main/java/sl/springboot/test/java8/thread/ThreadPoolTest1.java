package sl.springboot.test.java8.thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {
    public static void main(String[] args) {

//        fixedPool();
        singlePool();


    }

    static void cachedPool(){
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            pool.submit(new TestThread());
        }
        // 只是一个标记方法，调用此方法后 线程池不再接受新的任务
        pool.shutdown();
//        pool.submit(new TestThread());
    }

    static void fixedPool(){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            pool.submit(new TestThread());
        }
        // 只是一个标记方法，调用此方法后 线程池不再接受新的任务
        pool.shutdown();
    }
    static void singlePool(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for(int i=0;i<100;i++){
            pool.submit(new TestThread());
        }
        // 只是一个标记方法，调用此方法后 线程池不再接受新的任务
        pool.shutdown();
    }

}

class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName() + " is "+LocalDateTime.now());
    }
}
