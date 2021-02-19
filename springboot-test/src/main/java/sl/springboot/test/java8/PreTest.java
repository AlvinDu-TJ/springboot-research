package sl.springboot.test.java8;

import sl.springboot.test.java8.bean.Person;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PreTest {

    public static void main(String[] args) {
        Person p1= new Person("alvin", 35);
//        boolean result = handlePerson1(p1, namePredicate(), handleAlvinLogic());
//
//        System.out.println(result);

        handlePerson2(p1, namePredicate(), handleAlvinLogic());

    }

    private static Consumer<Person> handleAlvinLogic(){
        return a-> System.out.println(a.getName());
    }


    private static Predicate<Person> namePredicate(){
        return a -> a.getName().startsWith("alvin");
    }

    private static boolean handlePerson1(Person p, Predicate<Person> pre, Consumer<Person> c){
        Optional<Person> p1 = Optional.ofNullable(p);
        return p1.filter(pre).isPresent();
    }

    private static void handlePerson2(Person p, Predicate<Person> pre, Consumer<Person> c){
        Optional<Person> p1 = Optional.ofNullable(p);
        p1.filter(pre).ifPresent(c);
    }

}
