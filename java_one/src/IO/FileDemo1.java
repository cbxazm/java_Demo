package IO;

import java.io.File;

/**
 *构建File对象(参考api)
 */
public class FileDemo1 {
    public static void main(String[] args) {
        String path="F:/javaproject/java_one/src/11.png";
        //构建方法一
        File file=new File(path);
        System.out.println(file.length());//打印文件长度(多少k)589668k
        //构建方法二(只要路径拼接的出来就行，前面路径多写后面就少写)
        File file1=new File("F:/javaproject/java_one/src", "11.png");
        System.out.println(file1.length());
        //构建方法三
        File file2=new File(new File("F:/javaproject/java_one/src"), "11.png");
        System.out.println(file2.length());
        System.out.println(System.getProperty("user.dir"));
    }
}
