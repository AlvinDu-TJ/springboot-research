package sl.springboot.test.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {100, 200, 300, 400, 500, -600, -700, -800, -900, -1000};

        IntStream numbers1 = IntStream.of(numbers);

        OptionalInt max = numbers1.max();
        int asInt = max.getAsInt();
        System.out.println(asInt);


        Period period = Period.ofDays(6);
        period = Period.ofMonths(6);
        period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));

        System.out.println(period);

        List<String> names = Arrays.asList("Alex", "Brian", "Charles");

        Consumer<String> c1 = a -> a.toUpperCase();
        Consumer<String> c2 = System.out::println;
        Consumer<String> c3 = c2.andThen(c1);


        names.forEach(c2);

        System.out.println("-------------------------");
        Map<String, String> map = new HashMap<>();

        map.put("A", "Alex");
        map.put("B", "Brian");
        map.put("C", "Charles");

        BiConsumer<String, String> b1 = (k, v) -> System.out.println(k);

        BiConsumer<String, String> b2 = (k, v) -> System.out.println(v);

        map.forEach(b1.andThen(b2));

        System.out.println("-------------------------");

        Stream.generate(new Random()::nextInt)
                .limit(5).forEach(System.out::println);

        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream1 = list.stream();
        Integer[] evenNumbersArr = stream1.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.print(evenNumbersArr);


        Map<Integer, List<Integer>> collect = Stream.generate(() ->
                new Random().nextInt(10)).limit(100).collect(Collectors.groupingBy
                (Function.identity()));

        collect.entrySet().stream().forEach((k) -> {
            System.out.println(k.getKey() + "count is " + k.getValue().size());
        });


        IntStream.of(1, 2, 3, 4, 5).boxed()
                .collect(Collectors.toList());


        Optional<Integer> max1 = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .max(Integer::compareTo);

        System.out.println(max1.get());

        Optional<Integer> max2 = IntStream.of(1, 2, 3, 4, 5)
                .boxed().filter(a -> a > 10).findAny();

        System.out.println(max2.isPresent());

        int b = 1;

        Stream.generate(() -> b)
                .limit(5).forEach(System.out::println);

        new Thread(()->System.out.println(LocalDateTime.now())).start();

        List<Integer> integers = Arrays.asList(1,12,433,5);

        Optional<Integer> max3 = integers.stream().reduce( Math::max );

        max3.ifPresent( System.out::println );

        Optional<Integer> possible = Optional.ofNullable(null);
        possible.ifPresent(a->{
            System.out.println(a);
        });


        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());                //2013-05-15
        System.out.println(localDate.getDayOfWeek().toString()); //WEDNESDAY
        System.out.println(localDate.getDayOfMonth());           //15
        System.out.println(localDate.getDayOfYear());            //135
        System.out.println(localDate.isLeapYear());              //false
        System.out.println(localDate.plusDays(12).toString());   //2013-05-27


        period = Period.ofMonths(6);
        System.out.println(period.toString());



    }
}
