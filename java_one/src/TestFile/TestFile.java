package TestFile;
/**
 * 测试file类
 */

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) throws IOException {
//        File file=new File("d:/a.txt");
        File file=new File("d:\\a.txt");
       file.renameTo(new File("d:/b.txt"));
        System.out.println(file);
        //获取用户的工作空间F:\javaproject
        System.out.println(System.getProperty("user.dir"));
        File file1=new File("gg.txt");
        file1.createNewFile();//如果不加任何地址，默认在当前的项目路径下创建
        System.out.println(file1.isDirectory());//false
        System.out.println(file1.isFile());//true
        System.out.println(new Date(file1.lastModified()));//最后的修改时间
        System.out.println(file1.length());//文件大小
        System.out.println(file1.getName());//文件名称
        System.out.println(file1.getPath());//获取文件的目录路径(相对于src下的)gg.txt
        System.out.println(file1.getAbsolutePath());//获取绝对路径F:\javaproject\gg.txt
        /**
         * mkdir以及mkdirs的区别
         */
//        File f3=new File("d:/电影/华语");
//        boolean b = f3.mkdir();//mkdir目录中只要有一个不存在，则创建目录树就是失败的
//        System.out.println(b);
        File f3=new File("d:/电影/华语");
        boolean b = f3.mkdirs();//mkdirs目录结构中有一个不存在没有关系，创建整个目录树
        System.out.println(b);
    }

}
