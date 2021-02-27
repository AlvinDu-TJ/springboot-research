package sl.springboot.test.java8.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer first = ((LinkedList<Integer>) list).getFirst();

        list.forEach(a->System.out.println(a));
    }
}
