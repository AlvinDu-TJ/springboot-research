package sl.springboot.test.interview;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerInterview {

    public static void main(String[] args) {
        final BlockingDeque<String> queue = new LinkedBlockingDeque<>(10);
        Thread producer = new Thread(){
            @Override
            public void run() {
               while(true){
                   try {
                       Thread.sleep(1000);
                       queue.put(""+ new Random().nextInt(10));
                       System.out.println("生产了一个");
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        };

        Thread consumer = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(500);
                        queue.take();
                        System.out.println("消费了一个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        producer.start();
        consumer.start();
    }
}
