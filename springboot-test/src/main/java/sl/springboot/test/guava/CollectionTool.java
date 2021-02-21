package sl.springboot.test.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTool {
    public static void main(String[] args) {
        // 1. 不可变集合, 应该仅可作为常量使用
        Map<String, String> m = new HashMap();
        m.put("k","v");
        ImmutableMap<String, String> stringStringImmutableMap = ImmutableMap.copyOf(m);
        m.put("p","v");
        System.out.println(stringStringImmutableMap);

        // 2. Multiset接口 它的元素可以重复出现, 可以统计一个词出现了多少次
        HashMultiset<String> hashMultiset = HashMultiset.create();
        hashMultiset.add("name");
        hashMultiset.add("name");

        System.out.println(hashMultiset.count("name"));

        // 3. 一键对多值 Multimap
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("name", "Jack");
        multimap.put("name", "Jack");
        multimap.put("name", "Tom");
        multimap.put("age", "10");
        multimap.put("age", "12");
        System.out.println(multimap);
        System.out.println(multimap.get("name").size());

        // 4. BitMap 提供双向映射关系
        BiMap<String,String> biMap= HashBiMap.create();
        biMap.put("sina","sina.com");
        biMap.put("qq","qq.com");
        biMap.put("sina","sina.cn"); //会覆盖原来的value
        System.out.println(biMap.inverse().get("qq.com"));

        //biMap.put("tecent","qq.com"); //抛出异常
        biMap.forcePut("tecent","qq.com"); //强制替换key
        System.out.println(biMap.get("qq")); //通过value找key
        System.out.println(biMap.inverse().get("qq.com"));
        System.out.println(biMap.inverse().get("sina.com"));
        System.out.println(biMap.inverse().inverse()==biMap);


        // 原始类型的对象。
        yuanyu();
        
        // 数学工具
        mathUtil();

    }

    private static void mathUtil() {
        try{
            System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(IntMath.divide(100, 5, RoundingMode.UNNECESSARY));
        try{
            //exception will be thrown as 100 is not completely divisible by 3 thus rounding
            // is required, and RoundingMode is set as UNNESSARY
            System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
        }catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): "+IntMath.log2(2, RoundingMode.HALF_EVEN));

        System.out.println("Log10(10): "+IntMath.log10(10, RoundingMode.HALF_EVEN));

        System.out.println("sqrt(100): "+IntMath.sqrt(IntMath.pow(10,2), RoundingMode.HALF_EVEN));

        System.out.println("gcd(100,50): "+IntMath.gcd(100,50));

        System.out.println("modulus(100,50): "+IntMath.mod(100,50));

        System.out.println("factorial(5): "+IntMath.factorial(5));
    }

    private static void yuanyu() {
        int[] intArray = {1,2,3,4,5,6,7,8,9};

        //convert array of primitives to array of objects
        List<Integer> objectArray = Ints.asList(intArray);
        System.out.println(objectArray.toString());

        //Returns the minimum		
        System.out.println("Min: " + Ints.min(intArray));

        //Returns the maximum
        System.out.println("Max: " + Ints.max(intArray));
    }
}
