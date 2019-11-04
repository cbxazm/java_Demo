package IO;

import java.io.*;

/**
 * 文件字节输出流和文件输入流 来进行文件拷贝的操作
 */
public class Copy {
    public static void main(String[] args) throws Exception {
        copy("java_one/test","java_one/dest");
    }
    public static void copy(String rootPath,String destPath) throws Exception{
        File root=new File(rootPath);//源头
        File dest=new File(destPath);//目的地
        InputStream inputStream=new FileInputStream(root);
        OutputStream outputStream=new FileOutputStream(dest);
        byte[] flush=new byte[1024];//缓冲容器
        int len=-1;
        while ((len=inputStream.read(flush))!=-1){
            outputStream.write(flush);
        }
        outputStream.flush();
        outputStream.close();
        /**
         * 先打开的后关闭，先输入流打开进行了操作
         */
        inputStream.close();
    }
}
