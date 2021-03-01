package sl.springboot.test.java8.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(5);
        new Thread(new Decrement(c)).start();
        new Thread(new Increment(c)).start();

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Decrement implements Runnable{

    CountDownLatch c;

    public Decrement(CountDownLatch c){
        this.c = c;
    }

    @Override
    public void run() {
        try {
        for (long i = c.getCount(); i>0; i--){

                TimeUnit.SECONDS.sleep(1);
            System.out.println("count down");
            this.c.countDown();

        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Increment implements  Runnable{

    CountDownLatch c;

    public Increment(CountDownLatch c){
        this.c = c;
    }

    @Override
    public void run() {
        try{
            System.out.println("await");
            c.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("wait released");
    }
}