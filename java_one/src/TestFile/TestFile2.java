package TestFile;

import java.io.File;

/**
 * 递归打印整个目录树
 */
public class TestFile2 {
    public static void main(String[] args) {
           File file=new File("d:/毕业论文");
          printFile(file,0);
    }
    static void printFile(File file,int level){
        //输出层数
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
              if(file.isDirectory()){
                  File[] files = file.listFiles();
                  for(File temp:files){
                      printFile(temp,level+1);
                  }
              }
    }
}
