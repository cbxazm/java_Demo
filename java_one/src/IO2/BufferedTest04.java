package IO2;

import java.io.*;

/**
 * 字符缓冲输出流
 */
public class BufferedTest04 {
    public static void main(String[] args) throws Exception{
        File src=new File("java_one/bb.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(src));
        bufferedWriter.append("IO| IS EASY");
        /**
         * 新增方法，增加换行符
         */
        bufferedWriter.newLine();
        bufferedWriter.append(" aaaa");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
