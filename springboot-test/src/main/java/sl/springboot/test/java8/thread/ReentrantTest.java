package sl.springboot.test.java8.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTest {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private void test() {
        lock.lock();
        try {
            condition.await();

            for (int i = 0; i < 10; i++) {
                System.out.println("\"Current thread\" + Thread.currentThread().getName() = " + "Current thread" + Thread.currentThread().getName() + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal() {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ReentrantTest test = new ReentrantTest();

        Runnable a = () -> test.test();
        Thread t = new Thread(a);
        t.start();

        TimeUnit.SECONDS.sleep(3L);
//
        test.signal();


    }
}
