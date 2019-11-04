package IO;

import java.io.*;

/**
 * 文件字节输出流
 */
public class IOTest04 {
    public static void main(String[] args) throws IOException {
//        创建不存在的文件
        File file=new File("java_one/dest.txt");
        OutputStream outputStream=new FileOutputStream(file,true);//加了true之后后面的文件会一直追加进去,不加会将原来的数据去掉
//操作(写出)
         String msg="IO HELLO dddd gssfgs\r\n";
              //字符串--》字节数组 编码
        byte[] bytes = msg.getBytes();
        outputStream.write(bytes);
           //刷新一下
        outputStream.flush();
        outputStream.close();
    }
}
