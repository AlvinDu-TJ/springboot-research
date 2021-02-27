package sl.springboot.test.java8.thread;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Alock implements Closeable {

    final private Lock lock;

    public Alock(){
        this(new ReentrantLock());
    }

    public Alock(ReentrantLock reentrantLock){
        this.lock = reentrantLock;
    }

    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }

    @Override
    public void close() throws IOException {
        System.out.println("unlock invoked>>>>>>>");
        lock.unlock();
    }
}
