package TestCollection;

/**
 * 自定义的arrayList,体会底层的原理
 * 增加泛型
 */
public class MyArrayList2 <E>{
//核心数组
    Object[] elementData;
    private int size;
    //默认的长度为10
    private static final int DEFAULT_CAPACITY=10;
    public MyArrayList2(){
        elementData=new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList2(int capacity){
     elementData=new Object[capacity];
    }
 public void add(E obj){
         elementData[size++]=obj;
 }

    @Override
    public String toString() {
       StringBuilder builder=new StringBuilder();
       builder.append("[");
     for(int i=0;i<size;i++){
         builder.append(elementData[i]+",");
     }
       builder.deleteCharAt(builder.length()-1);//把最后的一个逗号删除掉
       builder.append("]");
       return  builder.toString();
    }

    public static void main(String[] args) {
         MyArrayList2 arrayList=new MyArrayList2(10);
         arrayList.add("a");
         arrayList.add("b");
        System.out.println(arrayList);
    }
}
