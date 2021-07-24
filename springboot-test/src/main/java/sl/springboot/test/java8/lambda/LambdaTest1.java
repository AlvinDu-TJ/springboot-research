package sl.springboot.test.java8.lambda;

import com.google.common.base.Function;

public class LambdaTest1 {
    public static void main(String[] args) {
        Function<String, Object> stringObjectFunction = String::new;
        Object aaa = stringObjectFunction.apply("ppppppppp");
        System.out.println(aaa);
    }
}
