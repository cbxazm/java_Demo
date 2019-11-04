package IO2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 转换流
 * InputStreamReader
 * OutputStramWriter
 * 1.以字符流的形式处理字节流
 * 2.指定字符集
 */
public class ConvertTest {
         //读取百度源码
         public static void main(String[] args) throws Exception {
             try (BufferedReader reader=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
                  BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("java_one/baidu.html"),"UTF-8"));){
                 String msg;
                 while ((msg=reader.readLine())!=null){
                    writer.write(msg);
                    writer.newLine();
                 }
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
}
