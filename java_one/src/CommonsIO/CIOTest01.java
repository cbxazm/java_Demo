package CommonsIO;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 统计文件大小
 */
public class CIOTest01 {
    public static void main(String[] args) {
        long size = FileUtils.sizeOf(new File("F:\\javaproject\\java_one\\src\\Decorate\\DecorateTest01.java"));
        //对于统计文件夹也是一样的操作
    }
}
