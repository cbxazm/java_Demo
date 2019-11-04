package Encode;

import java.io.UnsupportedEncodingException;

/**
 * 字节--》字符串 ：解码
 * utf-8一个中文三个字节,一个英文一个字节
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
         String s="的哈所";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
//        解码
          s=new String(bytes,0,bytes.length,"utf-8");
        System.out.println(s);
    }
}
