package sl.springboot.test.java8.jvm;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//GC 测试， 使用java visualVM 查看GC
public class HeapTest {
    byte[] a= new byte[1024*100]; //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> a = new ArrayList<>();
        while (true){
            a.add(new HeapTest());
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}
