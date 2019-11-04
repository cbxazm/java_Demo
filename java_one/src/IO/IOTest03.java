package IO;

import java.io.*;

/**
 * 文件字节输入流
 */
public class IOTest03 {
    public static void main(String[] args) throws IOException {
        File file=new File("java_one/test.txt");
        InputStream inputStream=new FileInputStream(file);
          byte[] flush=new byte[3];//缓冲容器(一个英文一个字节utf-8)1k=1024个字节
           int len;
           while ((len=inputStream.read(flush))!=-1){
                 String str=new String(flush,0,len);
               System.out.println(str);
           }

    }
}
