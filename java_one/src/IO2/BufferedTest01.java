package IO2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 字节缓冲输入流
 */
public class BufferedTest01 {
    public static void main(String[] args) throws Exception{
        File src=new File("java_one/bb.txt");
//        InputStream inputStream=new FileInputStream(src);
//        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        InputStream inputStream=new BufferedInputStream(new FileInputStream(src));
        byte[] flush=new byte[1024];
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
            String str=new String(flush,0,len);
            System.out.println(str);
        }
        inputStream.close();
    }
}
