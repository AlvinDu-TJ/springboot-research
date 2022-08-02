package sl.springboot.test.java8.stream;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {

    public static void main(String[] args) {
        String[] arrayA=new String[]{"1","2","3","4"};
        String[] arrayB=new String[]{"3","4","5","6"};
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        //交集
        List<String> intersection = listA.stream().filter(item -> listB.contains(item)).collect(Collectors.toList());
        System.out.println(intersection); //输出：[3, 4]

        // 并集（新建集合：1、是因为不影响原始集合，2、    Arrays.asList不能add和remove操作）
        List<String> listAll = listA.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = listB.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println(listAll); //输出：[1, 2, 3, 4, 3, 4, 5, 6]

        // 差集
        List<String> reduceList = listA.stream().filter(item -> !listB.contains(item)).collect(Collectors.toList());
        System.out.println(reduceList); //输出：[1, 2]

        // 去重并集
        ArrayList<String> list = new ArrayList<>(listA);
        list.addAll(listB);
        List<String> listAllDistinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(listAllDistinct); //输出：[1, 2, 3, 4, 5, 6]

        System.out.println(CollectionUtils.union(listA,listB)); //输出：[1, 2, 3, 4, 5, 6] //2、交集intersection
        System.out.println(CollectionUtils.intersection(listA,listB)); //输出：[3, 4] //3、交集的补集(析取)disjunction
        System.out.println(CollectionUtils.disjunction(listA,listB)); //输出：[1, 2, 5, 6] //4、差集(扣除)
        System.out.println(CollectionUtils.subtract(listA,listB)); //[1, 2]

    }
}
