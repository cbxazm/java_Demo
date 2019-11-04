package TestFile;

import java.io.File;

public class DirDemo1 {
    public static void main(String[] args) {
        File file=new File(System.getProperty("user.dir")+"/java_one/src/aa/bb");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
//        System.out.println(System.getProperty("user.dir"));
    }
}
