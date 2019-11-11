package IO2;
import java.io.*;
/**
 * 打印流
 */
public class PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        java.io.PrintStream out =System.out;
        out.println("aa");

//构造器中加入true就是会自动刷新流
        out=new java.io.PrintStream(new BufferedOutputStream(new FileOutputStream("java_one/nn.txt")),true);
        out.println("vvv");
        out.flush();
//        重定向输出端
        System.setOut(out);
        out.flush();
        System.out.println("aaaaa");
//        重定向到控制台
        System.setOut(new java.io.PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("back");
        out.close();
    }
}
