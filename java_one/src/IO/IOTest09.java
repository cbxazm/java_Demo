package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输出流
 * 源：是一个字节数组，但是不要太大
 * 不需要释放资源 (字节数组在虚拟机的内存上)
 */
public class IOTest09 {
    public static void main(String[] args) throws IOException {
        //创建源
        byte[] dest=null;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        String msg="show me the code";
        byte[] bytes = msg.getBytes();
           byteArrayOutputStream.write(bytes,0,bytes.length);
           //获取数据
        dest=byteArrayOutputStream.toByteArray();
        System.out.println(dest.length+"-->"+new String(dest,0,dest.length));
           byteArrayOutputStream.flush();
           byteArrayOutputStream.close();
    }
}
