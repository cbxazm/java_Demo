package TestException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 所有不是runtimeexception的异常，都称为checkedException,在编译的时候就会报错
 */
public class TestException1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=null;
        try {
             fileReader=new FileReader("d:/b.txt");
            char read = (char)fileReader.read();
            System.out.println(read);
        } catch (FileNotFoundException e) {
//            子类异常在前，父类异常在后(不然后面的异常捕获不到)
            //打印异常信息
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                //不然会空指针
                fileReader.close();
            }

        }
    }
}
           class run extends RuntimeException{

        }
