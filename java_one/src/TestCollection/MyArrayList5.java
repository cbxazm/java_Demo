package TestCollection;

/**
 * 自定义的arrayList,体会底层的原理
 * 增加泛型
 * 增加数组扩容
 * 增加set()和get()方法，以及数组索引越界问题
 * 增加remove()方法(jdk源码提供两种实现方法,一种通过索引来删除，一种通过一个个比较对象的方法来删除)
 */
public class MyArrayList5<E>{
//核心数组
    Object[] elementData;
    private int size;
    //默认的长度为10
    private static final int DEFAULT_CAPACITY=10;
    public MyArrayList5(){
        elementData=new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList5(int capacity){
        if(capacity<0){
            throw new RuntimeException("输入的容量不合理");
        }else if(capacity==0){
            elementData=new Object[DEFAULT_CAPACITY];
        }else {
            elementData=new Object[capacity];

        }
    }
    public int size(){
        return size;
    }
     public boolean isEmpty(){
        return size==0?true:false;
     }
    public void remove(E element){
          //element，将它和所有的元素进行比较,获得第一个为true的，返回
        for(int i=0;i<size;i++){
                 if (element.equals(get(i))){
                //将该元素从此处移除
                     remove(i);
                 }
        }
    }
      public void remove(int index){
           //a,b,c,d,e,f,g
           //a,b,c,e,f,g删除了d，实际上还是利用了数组的拷贝
          int numRemoved=elementData.length-index-1;

          if (numRemoved>0) {
              System.arraycopy(elementData,index+1,elementData,index,numRemoved);
          }
          elementData[size-1]=null;
         size--;//或者两步并为一步elementData[--size]=null;

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
           public E get(int index){
        checkRange(index);
            return (E) elementData[index];
           }
      public void set(E element,int index){
             checkRange(index);
          elementData[index]=element;
      }

      public void checkRange(int index){
          //索引判断
          if(index<0||index>size-1){
              //不合法
              throw  new RuntimeException();
          }

      }
      
    public static void main(String[] args) {
         MyArrayList5 arrayList=new MyArrayList5(2);
         arrayList.add("a");
         arrayList.add("b");
         arrayList.add("c");
         arrayList.add("a");
        System.out.println(arrayList.size);
         arrayList.remove("a");
        System.out.println(arrayList);
//         arrayList.add("a");
//         arrayList.add(null);
//        System.out.println(arrayList.size);
//        System.out.println(arrayList);
//        System.out.println(arrayList.get(2));
//        arrayList.set("ddd",2);
//        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size);
    }
}
