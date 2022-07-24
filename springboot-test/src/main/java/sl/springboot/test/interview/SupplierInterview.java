package sl.springboot.test.interview;

import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierInterview {

    public static void main(String[] args) {
        final int[] arr= {1,2,3,99,5,6};
        int maxAge = getMax(()->{
            OptionalInt max = IntStream.of(arr).max();
            return max.getAsInt();
        });

        System.out.println("maxAge = " + maxAge);
    }

    private static int getMax(Supplier<Integer> o) {
        return o.get();
    }
}
