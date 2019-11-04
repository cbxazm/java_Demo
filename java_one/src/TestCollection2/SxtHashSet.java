package TestCollection2;

import java.util.HashMap;

/**
 * 自定义的hashset
 */
public class SxtHashSet {
    HashMap map;
  private static final Object PRESENT=new Object();
    public SxtHashSet() {
        map=new HashMap();
    }
    public  void add(Object o){
        map.put(o,PRESENT);
    }
    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("[");
        for (Object key:map.keySet()){
         builder.append(key+",");
        }
        builder.setCharAt(builder.length()-1,']');
        return builder.toString();
    }

    public static void main(String[] args) {
        SxtHashSet sxtHashSet=new SxtHashSet();
        sxtHashSet.add("aaa");
        sxtHashSet.add("bbb");
        sxtHashSet.add("ccc");
        System.out.println(sxtHashSet);
    }
}
