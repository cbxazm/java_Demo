package TestCollection;

//import javax.xml.soap.Node;

/**
 * 手工实现链表
 * 增加get()方法
 * 增加remove()方法
 * 增加插入节点的方法add()
 */
public class MyLinkedList4 {
    private Node first;
    private Node last;
    private int size;

    public static void main(String[] args) {
        MyLinkedList4 list1 = new MyLinkedList4();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);
//        System.out.println(list1.get(2));
//        System.out.println(list1.size);
//        list1.remove(2);
//        list1.remove(0);
//        list1.remove(1);
//        list1.add(1,"d");
//        list1.add(2,"d");
        list1.add(0,"ddd");
        list1.add(0,"ccc");
        System.out.println(list1);

    }
    public void add(int index,Object obj){
              Node newNode=new Node(obj);
              Node temp=getNode(index);
              if(temp!=null){
                    if(index==0){
                     newNode.next=temp;
                     temp.previous=newNode;
                      first=newNode;
                    }else {
                        Node up=temp.previous;
                        up.next=newNode;
                        newNode.previous=up;
                        newNode.next=temp;
                        temp.previous=newNode;
                    }
              }
    }
    public Node getNode(int index){
        Node temp=null;
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合理");
        }
        if(index<=size>>1){
            //小于等于链表的一半，从头开始找
            temp=first;
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
        }else {
            temp=last;
            for(int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }
        return temp;
    }
    //["a","b","c","d","e"]
    public void remove(int index){
        Node temp = getNode(index);//获取要删除的节点
        if(temp!=null){
            Node up=temp.previous;
            Node down=temp.next;
            if (up!=null){
                up.next=down;
            }
            if(down!=null){
                down.previous=up;
            }
            if (index==0){
                first=down;
            }
            if (index==size-1){
            last=up;
            }
            size--;
        }

    }
    //["a","b","c","d","e"]//假设获取index=2,就是first.next.next
        public Object get(int index){
        if(index<0||index>size-1){
            throw new RuntimeException("索引数字不合理");
        }
          Node temp=getNode(index);
        return temp.element!=null?temp.element:null;

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

