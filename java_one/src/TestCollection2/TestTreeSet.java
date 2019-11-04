package TestCollection2;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet的底层也是由treeMap实现的
 * 按照元素递增方向排序
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();
        set.add(100);
        set.add(200);
        for(Integer integer:set){
            System.out.println(integer);
        }
    }
    /**
     * 对于自定义类的递增，需要实现一个comparable接口
     * 具体参考TestTreeMap.java
     */
}
