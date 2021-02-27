package sl.springboot.test.java8.object;

public class ObjectTest {

    public static void main(String[] args) {
        Object a = new Object();
//        java6、7默认是返回随机数
//        java8默认是通过和当前线程有关的一个随机数+三个确定值，运用Marsaglia’s xorshift scheme随机数算法得到的一个随机数
        System.out.println(a.hashCode());
        System.out.println(Integer.toHexString(a.hashCode()));

    }
}
