package IO;

import java.io.*;

/**
 * 文件字符输出流
 */
public class IOTest07 {
    public static void main(String[] args) throws IOException {
        File file=new File("java_one/test2.txt");
        Writer writer=new FileWriter(file);
        String msg="IO AAA";
        char[] chars=msg.toCharArray();
        writer.write(chars);
        writer.flush();
        writer.close();

    }
}
