package TestCollection2;

/**
 * 自定义的hashmap
 * 重写toString()打印map内容
 * 增加查找键值对的get()方法
 * 完善封装，增加泛型
 */
public class SxtHashMap4<K,V>{
    //位桶数组
      Node2[] table;//默认长度就是16
      int size;//存放键值对的个数
    public SxtHashMap4(){
        table=new Node2[16];//长度一定是2的整数次幂
    }

    public static void main(String[] args) {
        SxtHashMap4<Integer,String> hashMap=new SxtHashMap4<>();
        hashMap.put(10,"aa");
        hashMap.put(20,"bb");
        hashMap.put(30,"cc");
//        hashMap.put(20,"bbbbb");//会把前面的覆盖掉
        hashMap.put(36,"hhh");
        System.out.println(hashMap);
        System.out.println(hashMap.get(30));
    }
     public V get(K key){
        //先求出hash值
        int hash=myHash(key.hashCode(),table.length);
        V value=null;
          if(table[hash]!=null){
              Node2 temp=table[hash];//第一个节点
              while (temp!=null){
                    if(temp.key.equals(key)){
                        //说明找到了键值对
                        value=(V)temp.value;
                        break;
                    }else {
                        temp=temp.next;
                    }
              }
          }
          return (V)value;
     }
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("{");
        for(int i=0;i<table.length;i++){
            Node2 temp=table[i];
            while (temp!=null){
                builder.append(temp.key+":"+temp.value+",");
                temp=temp.next;
            }
        }
       builder.setCharAt(builder.length()-1,'}');
        return builder.toString();

    }

    public void put(K key, V value){
        /**
         * 如果要完善，需要考虑数组扩容的问题
         */
        //定义新的节点对象
        Node2 newNode2=new Node2();
        newNode2.hash=myHash(key.hashCode(),table.length);
        newNode2.key=key;
        newNode2.value=value;
        newNode2.next=null;
        //将节点放入
        Node2 temp=table[newNode2.hash];
        Node2 iterLast=null;//正在遍历的最后一个元素
        boolean keyRepeat=false;//判断是否发生了key重复的现象
        if(temp==null){
            //temp为空就直接放进去
            table[newNode2.hash]=newNode2;
            size++;
        }else {
                //元素不为空，遍历链表
                while (temp!=null){
                    if(temp.key.equals(key)){
                        keyRepeat=true;
                        //判断key如果重复，则覆盖
                        temp.value=value;//其他三个属性key,next,hash)都不需要再变
                        break;//找到直接结束循环，没有就一直遍历下去
//                        System.out.println("key重复了");
                    }else {
                        //key不重复，则遍历下一个
                        iterLast=temp;
                        temp=temp.next;
                    }
                }
                if(keyRepeat==false){
                    //没有发生重复，则返回遍历结果
                    iterLast.next=newNode2;
                }
        }

    }
    /**
     * 获取hash值的方法
     */
    public int myHash(int v,int length){
        //两种算出hash值的方式，上面的那个效率高
        System.out.println("hash值为:"+(v&(length-1)));
        System.out.println("hash值为："+(v%(length)));
        return v&(length-1);
    }
}
