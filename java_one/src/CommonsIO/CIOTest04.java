package CommonsIO;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 写出内容
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
//        最后一个参数是是否追加文件
        FileUtils.write(new File("java_one/happy.txt"),"happy","UTF-8",true);
//        三个方法效果是一样的
        FileUtils.writeStringToFile(new File("java_one/happy.txt"),"happy","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("java_one/happy.txt"),"happy".getBytes("UTF-8"),true);
    //写出列表
        List<String> list=new ArrayList<String>();
        list.add("dada");
        list.add("wwww");
//        第三个条目为元素之间的间隔符
        FileUtils.writeLines(new File("F:\\javaproject\\java_one\\dest.txt"),list,"-->",true);

    }
}
