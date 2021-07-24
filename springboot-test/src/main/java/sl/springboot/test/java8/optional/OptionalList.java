package sl.springboot.test.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalList {
    public static void main(String[] args) {
            List<String> personList = new ArrayList<>();
            personList.add(null);
            personList.add("小明");
            personList.add("小红");

            Optional.ofNullable(personList).orElseGet(() -> {
                System.out.println("personList为null！");
                return new ArrayList<>();
            }).stream().filter(Objects::nonNull).forEach(person -> {
                System.out.println(person);
            });
    }
}
