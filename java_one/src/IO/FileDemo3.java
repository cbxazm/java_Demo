package IO;

import java.io.File;

/**
 * 文件的状态
 */

public class FileDemo3 {
    public static void main(String[] args) {
        File src=new File("F:\\javaproject\\java_one\\11.png");
        System.out.println(src.exists());
//        System.out.println(src.listFiles());
        System.out.println(src.isFile());
        System.out.println(src.isDirectory());
    }



}
