package sl.springboot.test.java8.string;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("ab");
        System.out.println(sb.hashCode());
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);


        sb.setCharAt(1,'c');
        System.out.println(sb.hashCode());
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

    }
}
