package TestIterator;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * 使用map和list来存储表格
 * 每一行使用Map
 * 整个表格使用List
 */
public class SaveForm {
    public static void main(String[] args) {
        Map<String,Object> row1=new HashMap<>();
        row1.put("id",1000);
        row1.put("姓名","张三");
        row1.put("薪水",20000);
        row1.put("入职日期","2018.5.5");
        Map<String,Object> row2=new HashMap<>();
        row2.put("id",2000);
        row2.put("姓名","李四");
        row2.put("薪水",3999);
        row2.put("入职日期","2018.3.5");
        Map<String,Object> row3=new HashMap<>();
        row3.put("id",3000);
        row3.put("姓名","王五");
        row3.put("薪水",8888);
        row3.put("入职日期","2019.5.5");
        List<Map<String,Object>> table1=new ArrayList<>();
        table1.add(row1);
        table1.add(row2);
        table1.add(row3);
        for(Map<String,Object> row:table1){
            Set<String> keySet = row.keySet();
            for(String key:keySet){
                System.out.print(key+":"+row.get(key)+"\t");
            }
            System.out.println();
        }
    }

}
