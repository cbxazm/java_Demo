package CommonsIO;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *读取内容
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        String s = FileUtils.readFileToString(new File("F:\\javaproject\\java_one\\nn.txt"), "UTF-8");
        System.out.println(s);
        //读取字节数组
        byte[] bytes = FileUtils.readFileToByteArray(new File("F:\\javaproject\\java_one\\nn.txt"));
        System.out.println(bytes.length);
//        逐行读取
        List<String> list = FileUtils.readLines(new File("F:\\javaproject\\java_one\\nn.txt"),"UTF-8");
        for (String s1:list){
            System.out.println(s1);
        }
//        逐行读取2
        LineIterator lineIterator = FileUtils.lineIterator(new File("F:\\javaproject\\java_one\\nn.txt"), "UTF-8");
            while (lineIterator.hasNext()){
                System.out.println(lineIterator.nextLine());
            }
                }
}
