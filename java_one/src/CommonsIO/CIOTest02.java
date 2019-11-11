package CommonsIO;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 列出子孙集
 */
public class CIOTest02 {
    public static void main(String[] args) {
/**
 *       第一个参数
          EmptyFileFilter.NOT_EMPTY 是过滤器
          new SuffixFilter("java")表示只需要拿后缀是java的
          FileFilterUtils.or(new SuffixFilter("java"),new SuffixFilter("class"))表示需要后缀为.java或者后缀为.class的文件
          FileFilterUtils.and(new SuffixFilter("java"),EmptyFileFilter.NOT_EMPTY)表示后缀不为空且为.java的文件
  */

          //第二个参数过滤目录的  默认是一层，DirectoryFileFilter.INSTANCE是子孙集也显示

        Collection<File> files = FileUtils.listFiles(new File("F:\\javaproject\\java_one\\src\\IO"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
