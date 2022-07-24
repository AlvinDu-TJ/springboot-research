package sl.springboot.test.java8.stream;

import com.google.common.collect.ImmutableList;

import java.util.IntSummaryStatistics;

public class MapToInt {

    public static void main(String[] args) {

        Person p1 = new Person(1,"tom");
        Person p2 = new Person(2,"jerry");
        Person p3 = new Person(3,"ford");
        ImmutableList<Person> of = ImmutableList.of(p1, p2, p3);

        IntSummaryStatistics intSummaryStatistics = of.stream().mapToInt(Person::getAge).summaryStatistics();
        System.out.println("intSummaryStatistics.getAverage() = " + intSummaryStatistics.getAverage());
        System.out.println("intSummaryStatistics.getMax() = " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getMin() = " + intSummaryStatistics.getMin());
        System.out.println("intSummaryStatistics.getCount() = " + intSummaryStatistics.getCount());
        System.out.println("intSummaryStatistics.getSum() = " + intSummaryStatistics.getSum());

    }

    static class Person{
        private Integer age;
        private String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
