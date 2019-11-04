package TestCollection2;

/**
 * 自定义的hashmap
 * 重写toString()打印map内容
 */
public class SxtHashMap2 {
    //位桶数组
      Node[] table;//默认长度就是16
      int size;//存放键值对的个数
    public SxtHashMap2(){
        table=new Node[16];//长度一定是2的整数次幂
    }

    public static void main(String[] args) {
        SxtHashMap2 hashMap=new SxtHashMap2();
        hashMap.put(10,"aa");
        hashMap.put(20,"bb");
        hashMap.put(30,"cc");
//        hashMap.put(20,"bbbbb");//会把前面的覆盖掉
        hashMap.put(36,"hhh");
        System.out.println(hashMap);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("{");
        for(int i=0;i<table.length;i++){
            Node temp=table[i];
            while (temp!=null){
                builder.append(temp.key+":"+temp.value+",");
                temp=temp.next;

            }
        }
       builder.setCharAt(builder.length()-1,'}');
        return builder.toString();

    }

    public void put(Object key, Object value){
        //定义新的节点对象
        Node newNode=new Node();
        newNode.hash=myHash(key.hashCode(),table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;
        //将节点放入
        Node temp=table[newNode.hash];
        Node iterLast=null;//正在遍历的最后一个元素
        boolean keyRepeat=false;//判断是否发生了key重复的现象
        if(temp==null){
            //temp为空就直接放进去
            table[newNode.hash]=newNode;
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
                    iterLast.next=newNode;
                    size++;
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
