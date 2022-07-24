package sl.springboot.test.java8.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class FlatMap {

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(asList(1, 2), asList(3, 4)).flatMap(
                integers -> integers.stream()).collect(toList());

        System.out.println("collect = " + collect);

        System.out.println("--------------------------------------------");


        LongStream longStream = Stream.of(asList(1, 2), asList(3, 4)).flatMapToLong(x -> x.stream().mapToLong(i -> Long.parseLong(i + "")));
        ArrayList<Long> collect1 = longStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        HashSet<Long> collect2 = longStream.collect(HashSet::new, HashSet::add, HashSet::addAll);

        collect1.forEach(System.out::println);


        System.out.println("--------------------------------------------");
        String[][] arrayOfArrays = {{"1", "2"}, {"5", "6"}, {"3", "4"}};


        LongStream longStream1 = Arrays.stream(arrayOfArrays)
                .flatMapToLong(childArray -> Arrays.stream(childArray)
                        .mapToLong(Integer::new));
        long sum = longStream1.peek(System.out::println)
                .sum();
        System.out.println("sum: " + sum);

    }
}
