package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类
 */
public class Test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
             list.add("gao"+i);
        }
        System.out.println(list);
        Collections.shuffle(list);//随机排列List中的元素
        System.out.println(list);
        Collections.reverse(list);//逆序list中的元素
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);//按照正常（递增）的顺序进行排列，自定义类需要实现comparable接口
        System.out.println(Collections.binarySearch(list,"gao5"));

    }
}
