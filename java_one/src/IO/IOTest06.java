package IO;

import java.io.*;

/**
 * 文件字符输入流
 */
public class IOTest06 {
    public static void main(String[] args) throws IOException {
        File file=new File("java_one/test.txt");
        Reader reader=new FileReader(file);
        char[] flush=new char[1024];
        int len=-1;
        while ((len=reader.read(flush))!=-1){
            String str=new String(flush,0,len);
            System.out.println(str);
        }
    }
}
