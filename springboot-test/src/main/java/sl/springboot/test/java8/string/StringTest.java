package sl.springboot.test.java8.string;

public class StringTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        // 一个在常量池， 一个在堆内存
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String c = "a" + "b" + "c";



        System.out.println(a== c);

    }
}
