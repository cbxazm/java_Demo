package IO2;

import java.io.*;
import java.nio.Buffer;

/**
 * 操作对象数据流
 * 只有实现了序列化接口的对象才可以写入该流
 */
public class ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));
//        写入一个字符串对象演示
        objectOutputStream.writeObject("aaa");
        objectOutputStream.writeObject(new Employee("张三","123"));
    objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        System.out.println(bytes.length);
        //读取对象数据
        ObjectInputStream objectInputStream=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
        String msg= (String) objectInputStream.readObject();
        Object o=objectInputStream.readObject();
        System.out.println(msg);
        System.out.println(o);

    }
}
class Employee implements Serializable{
     private transient String name;//加入transient就是表示该字段不需要序列化
      private String password;

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
