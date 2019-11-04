package IO;

import java.io.File;

public class PathDemo1 {
    /**
     * / 名称分隔符 separator,在windows操作系统需要加一个转译符
     * @param args
     */
    public static void main(String[] args) {
          String path="F:\\javaproject\\java_one\\src\\11.png\n";
        System.out.println(File.separatorChar);
        /**
         * 建议使用的路径方式
         */
        //1.建议使用
        path="F:/javaproject/java_one/src/11.png";
        //2.常量拼接
//        path="D"+File.separator+"java".......
    }
}
