package IO;

import java.io.*;

/**
 * 封装拷贝
 * 封装释放
 */
public class FileUtils {
    public static void main(String[] args) throws IOException {
        /**
         * w文件之间的拷贝
         */
//                   InputStream inputStream=new FileInputStream("java_one/test.txt");
//                   OutputStream outputStream=new FileOutputStream("java_one/bb.txt");
//                   copy(inputStream,outputStream);
        /**
         * 文件到字节数组
         */
        InputStream inputStream=new FileInputStream("java_one/11.png");
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        copy(inputStream,byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();
        System.out.println(bytes.length);//589668
        /**
         * 字节数组到文件
         */
        InputStream inputStream1=new ByteArrayInputStream(bytes);
        OutputStream outputStream=new FileOutputStream("java_one/test.png");
        copy(inputStream1,outputStream);
    }
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] flush=new byte[1024];//缓冲容器
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
            outputStream.write(flush,0,len);
        }
//        outputStream.flush();
//        inputStream.close();
//        outputStream.close();
        close(inputStream,outputStream);
    }
    public static void close(Closeable... ios){
//        可变参数，无论多少个参数都可以，只要实现了Closeable接口的类
        for (Closeable closeable:ios){
            try {
                if(closeable!=null){
                    closeable.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
