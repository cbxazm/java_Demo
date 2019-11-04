package Encode;

import java.io.UnsupportedEncodingException;

/**
 * 字符串--》字节 ：编码
 * utf-8一个中文三个字节,一个英文一个字节
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
             String s="大家好a";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
//        编码成其他字符集
         bytes=s.getBytes("UTF-16LE");//统一两个字节
        System.out.println(bytes.length);
        bytes=s.getBytes("GBK");
        System.out.println(bytes.length);//中文两个字节，英文一个字节
    }
}
