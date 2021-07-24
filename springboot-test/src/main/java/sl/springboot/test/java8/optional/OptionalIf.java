package sl.springboot.test.java8.optional;

import java.util.*;
import java.util.function.Predicate;

public class OptionalIf {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("return_code", "SUCCESS");
        map.put("result_code", "a");

        System.out.println(dealWithMap(null));

//        Optional<Map<String, String>> optionalMap = Optional.ofNullable(map);


//        Predicate<Map<String, String>> p1 = t-> "FAIL".equals(t.get("return_code"));
//        Predicate<Map<String, String>> p2 = t-> "FAIL".equals(t.get("result_code"));
//        Map<String, String> stringStringMap = optionalMap.orElseGet(() -> new HashMap<>());
//        optionalMap.filter(p1.and(p2)).ifPresent(a->{
//            System.out.println("return code is fail");
//        });
    }

    protected static Response dealWithMap(Map<String, String> map){
        Optional<Map<String, String>> opMap = Optional.ofNullable(map);

        Response r = new Response();
        r.code = "empty";

        Predicate<Map<String, String>> p1 = t-> "FAIL".equals(t.get("return_code"));
        opMap.filter(p1).ifPresent(m->{
            r.code = "return code is fail";
        });


        Predicate<Map<String, String>> p2 = t-> "SUCCESS".equals(t.get("return_code"));
        Predicate<Map<String, String>> p3 = t-> "SUCCESS".equals(t.get("result_code"));

        opMap.filter(p2.and(p3)).ifPresent(m->{
            r.code = "return code and result code all success";
        });

        opMap.filter(p3.negate()).ifPresent(m->{
            r.code = "result code is not success";
        });

        return r;
    }


    private static class Response{
        public String code;

        @Override
        public String toString() {
            return "Response{" +
                    "code='" + code + '\'' +
                    '}';
        }
    }

}
