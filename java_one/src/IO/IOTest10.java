package IO;

import java.io.*;

/**
 * 图片读取到字节数组中
 * 字节数组写到文件中
 */
public class IOTest10 {
    public static void main(String[] args) throws IOException {
        //图片转为数组
        byte[] bytes = fileToByteArray("java_one/11.png");
//        System.out.println(bytes.length);
        //数组转换为图片
        byteArrayToFile(bytes,"java_one/aa.png");
    }

    /**
     * 图片到字节数组中
     */
    public static byte[] fileToByteArray(String filePath) throws IOException {
          //创建源
        File file=new File(filePath);
        InputStream inputStream=new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] flush=new byte[1024*10];
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
            byteArrayOutputStream.write(flush,0,len);
        }
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
    /**
     * 字节数组到图片中
     * 字节数组读取到程序
     * 程序写出到文件
     */
    public static void byteArrayToFile(byte[] src,String filePath) throws IOException {
         //创建源
        File dest=new File(filePath);
        InputStream inputStream=new ByteArrayInputStream(src);
        OutputStream outputStream=new FileOutputStream(dest);
        byte[] flush=new byte[5];
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
             outputStream.write(flush);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
