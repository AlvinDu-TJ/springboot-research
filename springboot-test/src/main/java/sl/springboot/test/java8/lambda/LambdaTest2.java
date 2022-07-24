package sl.springboot.test.java8.lambda;

public class LambdaTest2 {

    public static void main(String[] args) {
        Converter<String> t = LambdaTest2::subStr;
        String aaaa = t.convert("aaaa", 2);
        System.out.println("aaaa = " + aaaa);

        Converter2<String> t2 = Result::getResult;

        String t1 = t2.convert(new Result(),"t", 11);

        System.out.println("t1 = " + t1);

    }

    protected static String subStr(String str, Integer length){
        return str.substring(length);
    }

    @FunctionalInterface
    interface Converter<T>{
        T convert(String str, Integer length);
    }

    interface  Converter2<T>{
        T convert(Result rs, String name,Integer i);
    }

    static class Result{
        public String getResult(String name, Integer i){
            return "a";
        }
    }
}
