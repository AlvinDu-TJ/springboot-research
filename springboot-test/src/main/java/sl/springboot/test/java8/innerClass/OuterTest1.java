package sl.springboot.test.java8.innerClass;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class OuterTest1 {

    public void test1(){
        List<String> a = Arrays.asList("aaa","bbb");
        // 外部变量 不需要显式 的声明final 了，此处编译器会做优化。
        // final只是表示一旦此变量初始化后，就不能再修改了

        /**
         * If it didn't do that, then code that changed the value of a local variable after
         * your object was constructed but before the inner class function runs might be confusing and weird.
         */
        String prefix = "prefix";
        a.forEach(b-> System.out.println(prefix+ b));
        a.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(prefix+ s);
            }
        });
        class Inner2{
            public void print(){
                System.out.println(prefix);
            }
        }

        new Inner2().print();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(prefix);
            }
        }).start();

    }

    public static void main(String[] args) {
        new OuterTest1().test1();
    }
}
