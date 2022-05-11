package sl.springboot.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        LongStream longStream = IntStream.range(1, 1000).asLongStream();
//        longStream.forEach(a->{
//            System.out.println(Thread.currentThread().getName()+" "+a);
//        });

//        longStream.parallel().forEach(a-> System.out.println(Thread.currentThread().getName()+" "+a));

        ForkJoinPool pool = new ForkJoinPool(10);
        AtomicLong b = new AtomicLong(1);
        List<Long> list  = new CopyOnWriteArrayList<Long>();
        pool.submit(() -> {
            longStream.parallel().forEach(a -> {
                System.out.println(Thread.currentThread().getName() + " " + a);
                b.incrementAndGet();
                list.add(a);
            });
        }).join();
        pool.shutdown();

        System.out.println(b.intValue());
        System.out.println(list.size());


        ExecutorService service = Executors.newCachedThreadPool();
        List lista = new ArrayList<String>();
        service.submit(() -> {

        });

        ForkJoinPool forkJoinPool = new ForkJoinPool(16);
    }
}
