package IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 * 源：是一个字节数组，但是不要太大
 * 不需要释放资源 (字节数组在虚拟机的内存上)
 */
public class IOTest08 {
    public static void main(String[] args) throws IOException {
//        创建源
       byte[] datas="你好 啊啊啊".getBytes();
        InputStream inputStream=new ByteArrayInputStream(datas);
        byte[] flush=new byte[1024*10];
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
            String str=new String(flush,0,len);
            System.out.println(str);
        }
    }
}
