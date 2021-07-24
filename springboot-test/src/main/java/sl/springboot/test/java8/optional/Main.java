package sl.springboot.test.java8.optional;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setTimeStr("2021-02-03");
        Person p1 = null;
        Optional.ofNullable(p1).map(Person::getTimeStr).ifPresent(t->{
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                p.setDateTime(sf.parse(t));
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        System.out.println(p);
    }
}
