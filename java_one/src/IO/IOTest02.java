package IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 创建源
 * 选择流
 * 操作(没读到数据返回-1)
 * 释放资源
 * 改进版
 */

public class IOTest02 {
    public static void main(String[] args) throws IOException {
        File file=new File("java_one/test.txt");
//        System.out.println(file.getAbsolutePath());
         //选择流
        InputStream stream=new FileInputStream(file);
          int temp;
          while ((temp=stream.read())!=-1){
              System.out.println((char) temp);
          }
               //释放资源
        stream.close();
    }
}
