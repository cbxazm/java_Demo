package IO;

import java.io.File;

/**
 * list获取下级名称
 * listFiles获取下级对象
 * listRoots()列出所有的盘符
 */
public class DirDemo1 {
    public static void main(String[] args) {
        File file=new File(System.getProperty("user.dir")+"/java_one");
//        System.out.println(file.getName());
//        String[] list = file.list();
//        for (String s:list){
//            System.out.println(s);
//        }
        File[] files = file.listFiles();
        for (File file1:files){
            System.out.println(file1.getName());
        }
        File[] files1 = file.listRoots();
        for (File file1:files1){
            System.out.println(file1);
        }
    }
}
