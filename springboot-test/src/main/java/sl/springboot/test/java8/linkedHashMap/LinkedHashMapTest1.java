package sl.springboot.test.java8.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest1 {

    public static void main(String[] args) {
        // true 按照访问顺序
        Map<Integer,Integer> map=new LinkedHashMap<>(10,0.75f,true);
        map.put(9,3);
        map.put(7,4);
        map.put(5,9);
        map.put(3,4);
        print(map);
        System.out.println("----------------------------");
        //如果按照访问顺序遍历，最近访问的会被放在链表最末尾的位同志
        map.get(9);
        map.get(3);
        print(map);

        System.out.println("-------------LRU 算法---------------");
        // use lru 算法

        Map<Integer,Integer> map2=new LRULinkedHashMap<>(4);
        map2.put(9,3);
        map2.put(7,4);
        map2.put(5,9);
        map2.put(3,4);
        map2.put(6,6);
        //总共put了5个元素，超过了指定的缓存最大容量
        print(map2);
    }

    protected static void print(Map<Integer,Integer> map){
        map.entrySet().forEach(k->{
            Integer key = k.getKey();
            Integer value = k.getValue();
            System.out.println(key + ">>>>" + value);
        });
    }
}

class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    //定义缓存的容量
    private int capacity;
    private static final long serialVersionUID = 1L;

    //带参数的构造器
    LRULinkedHashMap(int capacity) {
        //调用LinkedHashMap的构造器，传入以下参数， 此处第三个参数只在遍历的时候影响。
        super(16, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println("淘汰逻辑>>>>>"+eldest.getKey() + "=" + eldest.getValue());
        return size() > capacity;
    }
}
