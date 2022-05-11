package sl.springboot.test.string;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = b.intern();
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }


}
