package sl.springboot.test.java8.stream;

import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FinalOperator {
    public static void main(String[] args) {
        Stream<Integer> integerStream = asList(1, 2, 3, 4).stream().filter(a -> {
            System.out.println("a = " + a);
            return a / 2 == 0;
        });

        // system.out.println will not call if no final operation call, such as : collect.

    }
}
