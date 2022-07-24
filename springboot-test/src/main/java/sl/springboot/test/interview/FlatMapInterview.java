package sl.springboot.test.interview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapInterview {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"a","b"},{"c","d"},{"e","f"}};


        List result = Stream.of(array).flatMap(Stream::of).
                filter(a->!"a".equals(a)).collect(Collectors.toList());

        result.forEach(System.out::println);

    }
}
