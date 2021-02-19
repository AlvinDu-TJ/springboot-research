package sl.springboot.test.java8;

import sl.springboot.test.java8.bean.IfThen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IfThenTest {

    public static void main(String[] args) {

        IfThen i1 = new IfThen(get1p(), get1c());
        IfThen i2 = new IfThen(get2p(), get2c());
        List ifThenList = Stream.of(i1, i2).collect(Collectors.toList());


        Map<String, String> paramMap = new HashMap() {{
            put("fail", "fail1");
            put("fail", "fail2");
            put("success", "success1");
            put("success", "success2");
        }};

        handleMap(paramMap, ifThenList);
    }


    // 此处的map 可以理解成一个对象
    private static void handleMap(Map p, List<IfThen> ifThens) {
        Optional<Map> p1 = Optional.ofNullable(p);
        // 如果对象不为null, 并且能匹配到处理器，就用相应的处理器处理。
        ifThens.forEach(a -> p1.filter(a.getP()).ifPresent(a.getC()));

    }

    private static Predicate<Map> get1p() {
        return a -> a.get("fail") != null;
    }

    private static Consumer<Map> get1c() {
        return a -> System.out.println(a.get("fail"));
    }

    private static Predicate<Map> get2p() {
        return a -> a.get("success") != null;
    }

    private static Consumer<Map> get2c() {
        return a -> System.out.println(a.get("success"));
    }


}
