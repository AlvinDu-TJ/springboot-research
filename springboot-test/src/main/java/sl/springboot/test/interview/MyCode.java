package sl.springboot.test.interview;

import java.util.Optional;
import java.util.function.Function;

public class MyCode {

    interface Either<L, R> {

        boolean isLeft();

        boolean isRight();

        L getLeft();

        R getRight();

        <R2> Either<L, R2> map(Function<? super R, R2> func);//right value only

        //<R2> Either<L, R2> flatMap(Function<? super R, Either<L, R2>> func);
    }

    static class LeftImpl<L, R> implements Either<L,R>{

        private final L left;

        public LeftImpl(L l){
            left = l;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public L getLeft() {
            return left;
        }

        @Override
        public R getRight() {
            return null;
        }

        @Override
        public <R2> Either<L, R2> map(Function<? super R, R2> func) {
            return new LeftImpl(left);
        }

    }


    static class RightImpl<L, R> implements Either<L,R>{

        private R r;
        public RightImpl(R ra){
            r = ra;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public L getLeft() {
            return null;
        }

        @Override
        public R getRight() {
            throw new RuntimeException("wrong type");
        }

        @Override
        public <R2> Either<L, R2> map(Function<? super R, R2> func) {
            return (Either<L, R2>) func.apply(r);
        }
    }

    public static <L, R> Either<L, R> createLeft(L leftVal){
        return new LeftImpl<>(leftVal);
    }

    public static <L, R> Either<L, R> createRight(R rightVal){
        return new RightImpl<>(rightVal);
    }

    public static void main(String[] args) {
        Either<String, Double> sample1 = createLeft("wish me luck");
        System.out.println(sample1.isLeft()); //true
        System.out.println(sample1.isRight()); //false
        System.out.println(sample1.getLeft()); //1

        Object o = Optional.ofNullable(new Object()).orElseGet(() -> new Object());


    }



}
