package sl.springboot.test.collection;

import com.google.common.collect.ImmutableMap;

public class ImmutableCollection {
    public static void main(String[] args) {
        ImmutableMap<String , Integer> map = ImmutableMap.of("1",1,"2",2);
        System.out.println(map);
    }
}
