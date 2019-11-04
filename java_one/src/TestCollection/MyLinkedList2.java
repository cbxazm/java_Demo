package TestCollection;

//import javax.xml.soap.Node;

/**
 * 手工实现链表
 * 增加get()方法
 */
public class MyLinkedList2 {
    private Node first;
    private Node last;
    private int size;

    public static void main(String[] args) {
        MyLinkedList2 list1 = new MyLinkedList2();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);
        System.out.println(list1.get(2));
        System.out.println(list1.size);

    }
    //["a","b","c","d","e"]//假设获取index=2,就是first.next.next
        public Object get(int index){
            Node temp=first;
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合理");
        }
        if(index<=size>>1){
            //小于等于链表的一半，从头开始找
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
        }else {
             for(int i=size-1;i>index;i--){
                 temp=last;
                 temp=temp.previous;
             }
        }


            return temp.element;
        }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
//            System.out.println(temp.element);
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
        public void add (Object obj){
            Node node = new Node(obj);
            if (first == null) {
//          node.previous=null;
//          node.next
                first = node;
                last = node;
                size++;
            } else {
                node.previous = last;
                node.next = null;
                last.next = node;
                last = node;
                size++;
            }

        }
    }

