package sl.springboot.test.java8.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) {

        try(Alock lock = new Alock(new ReentrantLock())){
            lock.lock();
            throw  new RuntimeException("runtime exception");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
