package TestCollection;

/**
 * 自定义的arrayList,体会底层的原理
 * 增加泛型
 * 增加数组扩容
 */
public class MyArrayList3<E>{
//核心数组
    Object[] elementData;
    private int size;
    //默认的长度为10
    private static final int DEFAULT_CAPACITY=10;
    public MyArrayList3(){
        elementData=new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList3(int capacity){
     elementData=new Object[capacity];
    }
 public void add(E obj){

        //什么时候扩容？
     if(size==elementData.length){
         //怎么扩容？(长度为原长度加上原长度的一半)
         //这里必须加一个括号，优先级的问题
         Object[] newArray=new Object[elementData.length+(elementData.length>>1)];
            //数组的拷贝
         System.arraycopy(elementData,0,newArray,0,elementData.length);
         elementData=newArray;
     }
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
         MyArrayList3 arrayList=new MyArrayList3(2);
         arrayList.add("a");
         arrayList.add("b");
         arrayList.add("c");
        System.out.println(arrayList);
    }
}
