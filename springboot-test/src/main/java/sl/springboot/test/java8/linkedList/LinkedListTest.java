package sl.springboot.test.java8.linkedList;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.function.Supplier;

public class LinkedListTest {

    private static final Integer a = 12;

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer first = ((LinkedList<Integer>) list).getFirst();

        list.forEach(a->System.out.println(a));

        Supplier<Map<String, String>> supplier = () -> {
            HashMap<String, String> m = new HashMap<>();
            m.put("1","1");
            return m;
        };

        Map<String, String> map = supplier.get();

        System.out.println(map);


        // 匿名内部类的方式初始化list 不建议使用
        List<String> lista = new ArrayList<String>(2) {
            {
            add("1");
            add("2");
            }

            // 慎用， 非静态内部类/ 匿名内部类包含了外围实例的引用， 如果拥有比外部类更长的生命周期，
            // 有内存泄露隐患, 此处的a
            @Override
            public boolean add(String s) {
                return super.add(a+s);
            }
        };

        System.out.println(lista);

        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
//或者
        Map<String, String> test = ImmutableMap.<String, String>builder()
                .put("k1", "v1")
                .put("k2", "v2").build();

    }
}
