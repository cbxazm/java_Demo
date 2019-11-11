package IO2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象文件分割
 */
public class SplitFile {
    // 源头
    private File src;
    //目的地
    private String destDir;
    //分割后文件的存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数
    private int size;

    public SplitFile(File src, String destDir, int blockSize) {
        this.src = src;
        this.destDir = destDir;
        this.destPaths = new ArrayList<String>();
        this.blockSize = blockSize;
        init();
    }
//    初始化
    private void init(){
        //总长度
        long len=this.src.length();
    this.size=(int) Math.ceil(len*1.0/blockSize);
       //路径
        for (int i=0;i<this.size;i++){
               this.destPaths.add(this.destDir+"/"+i+"_"+this.src.getName());
        }

    }

    /**
     * 计算每一块的起始位置及大小
     * 分割
     */
    private void split() throws IOException {
         long len=src.length();
         int beginPos=0;
         int actualSize=(int) (blockSize>len?len:blockSize);
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
             splitDetail(i,beginPos,actualSize);
        }

    }
    public void splitDetail (int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile file=new RandomAccessFile(this.src,"r");
        RandomAccessFile file2=new RandomAccessFile(this.destPaths.get(i),"rw");
        file.seek(beginPos);
        byte[] flush=new byte[1024];
        int len=-1;
//        System.out.println(file.read(flush));
        while ((len=file.read(flush))!=-1){
            if(actualSize>len){
                //获取本次读取的所有内容
//                System.out.println(new String(flush,0,len));
                file2.write(flush,0,len);
                actualSize-=len;
            }else {
//                System.out.println(new String(flush,0,actualSize));
                file2.write(flush,0,actualSize);
                break;
            }
        }
        file.close();
        file2.close();

    }

    /**
     * 文件的合并
     * @param
     * @throws IOException
     */
    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(destPath,true));
        //输入流
        for (int i=0;i<destPaths.size();i++){
            InputStream inputStream=new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            //拷贝操作
            byte[] flush=new byte[1024];
            int len=-1;
            while ((len=inputStream.read(flush))!=-1){
                   outputStream.write(flush,0,len);
            }
            inputStream.close();
        }
        outputStream.flush();
        outputStream.close();



    }
    public static void main(String[] args) throws IOException {
     SplitFile splitFile=new SplitFile(new File("java_one/aa.png"),"F:\\javaproject\\java_one\\src\\aa\\bb",1024*10);
     splitFile.split();
     splitFile.merge("java_one/aaaaaaa.java");
    }
}
