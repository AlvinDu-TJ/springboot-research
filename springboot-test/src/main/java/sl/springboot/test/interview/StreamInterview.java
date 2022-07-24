package sl.springboot.test.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamInterview {

    static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setAge(new Random().nextInt(100));
            p.setName("name" + i);
            personList.add(p);
        }


        // 求和
        int sum = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println(sum);

        // 过滤求和
        int name = personList.stream().filter(a -> a.getName().startsWith("a"))
                .mapToInt(Person::getAge).sum();

        System.out.println(name);

        // 求最大, 最小 个数 平均数
        IntSummaryStatistics collect = personList.stream().collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("collect = " + collect);

        // 分组求和
        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.toList()));

        System.out.println("collect1 = " + collect1);
        collect1.forEach((key,list)-> {
            String s = "key " + key + " summary is " + list.stream().mapToInt(Person::getAge).sum();
            System.out.println("s = " + s);
        });

        // 排序. 先按照名字排 在按照 年龄排
        Stream<Person> sorted = personList.stream().sorted(Comparator.comparing(Person::getName).reversed().
                thenComparing(Comparator.comparing(Person::getAge).reversed()));
        sorted.forEach(System.out::println);
//        List<Person> collect2 = sorted.collect(Collectors.toList());

    }
}
