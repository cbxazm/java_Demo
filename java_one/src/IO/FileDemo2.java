package IO;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File src=new File("F:\\javaproject\\java_one\\11.png");
        System.out.println(src.getName());
        System.out.println(src.getPath());//给绝对路径就返回绝对路径，给相对路径就返回相对路径
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent());//就是上一级，无父路径则返回null
        System.out.println(src.getParentFile());//获取父对象
//        System.out.println(src);
    }



}
