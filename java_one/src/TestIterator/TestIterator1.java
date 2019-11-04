package TestIterator;

import java.util.*;

/**
 * 测试迭代器 遍历List,Set,Map
 */
public class TestIterator1 {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap2();
    }

    /**
     * 迭代器遍历list
     */
    public static void testIteratorList() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String temp = iterator.next();//获取当前目标，并且游标指向下一个对象
            System.out.println(temp);
        }
    }

    /**
     * 迭代器遍历set
     */
    public static void testIteratorSet() {
           Set<String> set=new HashSet<>();
           set.add("aa");
           set.add("bb");
           set.add("cc");
           for (Iterator<String> iterator=set.iterator();iterator.hasNext();){
               String temp = iterator.next();
               System.out.println(temp);
           }
    }
//    /**
//     * 迭代器遍历Map 方式一
//     */
//    public static void testIteratorMap() {
//        Map<Integer,String> map=new HashMap<>();
//        map.put(10,"qqa");
//        map.put(20,"bqqb");
//        map.put(30,"cqqc");
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for (Iterator<Map.Entry<Integer, String>> iterator=entries.iterator();iterator.hasNext();){
//            Map.Entry<Integer, String> temp = iterator.next();
//            System.out.println(temp.getKey()+"---"+temp.getValue());
//        }
//    }
    /**
     * 迭代器遍历Map 方式二(推荐使用这种方式)
     */
    public static void testIteratorMap2(){
        Map<Integer,String> map=new HashMap<>();
        map.put(10,"qqa");
        map.put(20,"bqqb");
        map.put(30,"cqqc");
        Set<Integer> keySet = map.keySet();
        for (Iterator<Integer> iterator=keySet.iterator();iterator.hasNext();){
            Integer key = iterator.next();
            System.out.println(key+"---"+map.get(key));
        }
    }

}