package sl.springboot.test.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BasicTool {

    public static void main(String[] args) {
        // 1. null optional
        Optional<Integer> possible = Optional.fromNullable(5);  //创建允许null值的Optional
        if(possible.isPresent()){//包含的引用非null的（引用存在），返回true
            System.out.println(possible.get());
        }else{
            System.out.println("possible is null");
        }
        Integer or = possible.or(10);

        System.out.println(or);

        Integer or1 = possible.orNull();

        System.out.println(or1);

        Set<Integer> integers = possible.asSet();

        System.out.println(integers);

        // 2. Preconditions 先决条件, 检查方法参数使用， 会抛出异常
        Preconditions.checkArgument(1==1);

        // 3. 连接器 Joiner， 线程安全 可以定义为  static final, 调用on 总是会返回一个新的实例 流式操作
        List<String> list1 = Arrays.asList("aa", "bb", "cc");
        System.out.println(Joiner.on("-").join(list1));

        List<String> list2 = Arrays.asList("aa", "bb", "cc", null, "dd");
        System.out.println(Joiner.on("-").skipNulls().join(list2));
        System.out.println(Joiner.on("-").useForNull("nulla").join(list2));

        // ImmutableMap 不可变的map 不支持改变内部元素
        Map map = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");
        System.out.println(Joiner.on("-").withKeyValueSeparator("=").join(map));


        // 4.  拆分器 Splitter 流式操作, 返回的并不是一个集合， 是一个迭代器
        String string = " ,a,b,";
        System.out.println(Splitter.on(",").split(string));
        // splitToList 这个可以转化成 list
        System.out.println(Splitter.on(",").splitToList(string));
        System.out.println(Splitter.on(",").trimResults().split(string));
        System.out.println(Splitter.on(",").omitEmptyStrings().split(string));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split(string));

        // 根据长度拆分
        string = "12345678";
        System.out.println(Splitter.fixedLength(2).split(string));

        // 拆分成Map
        System.out.println(Splitter.on("#").withKeyValueSeparator(":").split("1:2#3:4"));

        // 5. 字符串处理

        String aa = "12345";

        // A12345
        System.out.println(Strings.padStart(aa, 6, 'A'));
        // 12345
        System.out.println(Strings.padStart(aa, 5, 'A'));


        // 6. Ordering 多类型排序
        ordering();
        
        // 7. Objects equals 和 hashcode
        objectMethod();
        
        // 8. Range 获取一组数字/串在一个特定范围之内
        rangeMethod();

    }

    private static void rangeMethod() {
        // 包含两端 使用closed
        Range<Integer> range1 = Range.closed(0, 9);
        System.out.print("[0,9] : ");
        printRange(range1);
        System.out.println("5 is present: " + range1.contains(5));
        System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());

        //create a range (a,b) = { x | a < x < b}
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9) : ");
        printRange(range2);

        //create a range (a,b] = { x | a < x <= b}
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9] : ");
        printRange(range3);

        //create a range [a,b) = { x | a <= x < b}
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9) : ");
        printRange(range4);

        //create an open ended range (9, infinity
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9,infinity) : ");
        System.out.println("Lower Bound: " + range5.lowerEndpoint());
        System.out.println("Upper Bound present: " + range5.hasUpperBound());

        Range<Integer> range6 = Range.closed(3, 5);
        printRange(range6);

        //check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(9, 20);
        printRange(range7);
        //check ranges to be connected
        System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));

        Range<Integer> range8 = Range.closed(5, 15);

        //intersection， 交集
        printRange(range1.intersection(range8));

        //span 并集
        printRange(range1.span(range8));
    }

    private static void printRange(Range<Integer> range){
        System.out.print("[ ");
        // 转换成了一个set
        for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade +" ");
        }
        System.out.println("]");
    }

    private static void objectMethod() {
        System.out.println(Objects.equal("adf", "cvdf"));
        System.out.println(Objects.equal(1, null));
        System.out.println(Objects.hashCode(123));

    }

    private static void ordering() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        // natural 自然顺序， 元素必须都不为null
        Ordering ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(numbers);

        Collections.sort(numbers,ordering );
        System.out.println("Sorted List: ");
        System.out.println(numbers);

        System.out.println("======================");
        System.out.println("List is sorted: " + ordering.isOrdered(numbers));
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        // 倒序
        Collections.sort(numbers,ordering.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        // null 在第一位
        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        List<String> names = new ArrayList<String>();
        names.add("Ram");
        names.add("Shyam");
        names.add("Mohan");
        names.add("Sohan");
        names.add("Ramesh");
        names.add("Suresh");
        names.add("Naresh");
        names.add("Mahesh");
        names.add(null);
        names.add("Vikas");
        names.add("Deepak");

        System.out.println("Another List: ");
        System.out.println(names);

        // null 在第一给然后再倒序
        Collections.sort(names,ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);
    }


}
