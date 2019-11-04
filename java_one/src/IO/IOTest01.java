package IO;

import java.io.*;

/**
 * 创建源
 * 选择流
 * 操作(没读到数据返回-1)
 * 释放资源
 */
public class IOTest01 {
    public static void main(String[] args) throws IOException {
        File file=new File("java_one/test.txt");
//        System.out.println(file.getAbsolutePath());
         //选择流
        InputStream stream=new FileInputStream(file);
        //操作(读取)
        int data1 = stream.read();//读取第一个数据
          int data2=stream.read();//第二个数剧
        System.out.println((char) data1);
        System.out.println((char) data2);
               //释放资源
        stream.close();
    }
}
