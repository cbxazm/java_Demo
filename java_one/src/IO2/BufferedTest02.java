package IO2;

import java.io.*;

/**
 * 字节缓冲输出流
 */
public class BufferedTest02 {
    public static void main(String[] args) throws Exception {
        File src = new File("java_one/bb.txt");
        OutputStream  outputStream=new BufferedOutputStream(new FileOutputStream(src,true));
        String msg="IO love";
        byte[] datas=msg.getBytes();
        outputStream.write(datas);
        outputStream.flush();
        outputStream.close();

    }
}