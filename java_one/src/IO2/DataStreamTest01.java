package IO2;

import java.io.*;

/**
 * 数据流
 * 读取的顺序必须是一致的
 */
public class DataStreamTest01 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF("我的");
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeChar('a');
//        dataOutputStream.writeInt(17);
//        dataOutputStream.writeUTF("haha");
        byte[] bytes = byteArrayOutputStream.toByteArray();
        System.out.println(bytes.length);
        DataInputStream dataInputStream=new DataInputStream(new ByteArrayInputStream(bytes));
//        String msg=dataInputStream.readUTF();
//        int age=dataInputStream.readInt();
//        String msg1=dataInputStream.readUTF();
//        System.out.println(msg);

    }
}
