package TestCollection2;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 测试treeMap
 * 会自动按key递增的方式排序（如果是有些对象作为key，需要实现comparable接口来排序）
 */
public class TestTreeMap {
    public static void main(String[] args) {
       Map<Integer,String> treeMap1=new TreeMap<>();
        treeMap1.put(10,"aa");
        treeMap1.put(20,"bb");
        treeMap1.put(30,"cc");

        for (Integer key:treeMap1.keySet()){
            System.out.println(key+"---"+treeMap1.get(key));
        }
        Map<Emp,String> map=new TreeMap<>();
        map.put(new Emp(100,"张三",3000),"不错");
        map.put(new Emp(1040,"张飞",5000),"不错");
        map.put(new Emp(1004,"张六",6000),"不错");
        for (Emp key:map.keySet()){
            System.out.println(key+"---"+map.get(key));
        }
    }
}
class Emp implements Comparable<Emp>{
      int id;
      String name;
      double salary;

    @Override
    public String toString() {
        return "id:"+id+"-->name:"+name+"-->salary:"+salary;
    }

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp o) {
     //负数小于 0 等于 正数 大于
        if(this.salary>o.salary){
                return 1;
        }else if(this.salary<o.salary){
            return -1;
        }else {
           if(this.id>o.id){
               return 1;
           }else if(this.id<o.id){
               return -1;
           }else {
              return 0;
           }

        }
    }
}
