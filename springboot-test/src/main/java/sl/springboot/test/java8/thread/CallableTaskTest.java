package sl.springboot.test.java8.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTaskTest {
//    static int count =0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

       StringBuffer bf = new StringBuffer();
        FutureTask<String> futureTask = new FutureTask(()->{
            for (int i=0;i<100;i++){
                bf.append(i).append(",");
            }
            return bf.toString();
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        String result = futureTask.get();
        System.out.println(result);
    }
}
