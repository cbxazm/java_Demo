package IO2;

import java.io.*;

/**
 * 字符缓冲输入流
 */
public class BufferedTest03 {
    public static void main(String[] args) throws Exception{
        File src=new File("java_one/bb.txt");
        /**
         * 用到新增的方法，所以不要发生多态
         */
        BufferedReader bufferedReader=new BufferedReader(new FileReader(src));
        /**
         * 新增方法，逐行读取
         */
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
