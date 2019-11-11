package IO2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取写入流
 */
public class RandomTest {

    public static void main(String[] args) throws IOException {
        //分多少块
        File src=new File("F:\\javaproject\\java_one\\src\\TestCollection\\MyLinkedList5.java");
        //总长度(文件的字节数)
        long len=src.length();
        //每块的大小
        int blockSize=1024;
        //分多少块
        int size=(int) Math.ceil(len*1.0/blockSize);
//        System.out.println(size);//4块
         int beginPos=0;
         int actualSize=(int)(blockSize>len?len:blockSize);
         for (int i=0;i<size;i++){
              beginPos=i*blockSize;
              if(i==size-1){
                  actualSize= (int) len;
                  //最后一块
              }else {
                  actualSize=blockSize;
                  len-=actualSize;//剩余量
              }
             System.out.println(i+"-->"+beginPos+"-->"+actualSize);
              test2(i,beginPos,actualSize);
         }

    }

    /**
     * 对其进行分块操作，指定起始位置和实际长度以及操作第几块
     * @throws IOException
     */
    public static void test2(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile file=new RandomAccessFile(new File("F:\\javaproject\\java_one\\src\\TestCollection\\MyLinkedList5.java"),"r");
        file.seek(beginPos);
        byte[] flush=new byte[1024];
        int len=-1;
//        System.out.println(file.read(flush));
        while ((len=file.read(flush))!=-1){
            if(actualSize>len){
                //获取本次读取的所有内容
                System.out.println(new String(flush,0,len));
                actualSize-=len;
            }else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
        file.close();
    }
    /**
     * 读取指定大小的数据
     * @param
     * @throws IOException
     */
    public static void test1() throws IOException {
        RandomAccessFile file=new RandomAccessFile(new File("F:\\javaproject\\java_one\\src\\TestCollection\\MyLinkedList5.java"),"r");
        int beginPos=2;
        int actualSize=1026;
        //设定读取指针的位置
        file.seek(beginPos);
        byte[] flush=new byte[1024];
        int len=-1;
//        System.out.println(file.read(flush));
        while ((len=file.read(flush))!=-1){
            if(actualSize>len){
                //获取本次读取的所有内容
                System.out.println(new String(flush,0,len));
                actualSize-=len;
            }else {
                System.out.println(new String(flush,0,actualSize));
                break;
            }
        }
        file.close();
    }
    }

