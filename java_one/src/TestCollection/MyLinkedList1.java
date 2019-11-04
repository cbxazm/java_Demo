package TestCollection;

//import javax.xml.soap.Node;
import java.util.LinkedList;

/**
 * 手工实现链表
 */
public class MyLinkedList1 {
    private Node first;
    private Node last;
    private int size;

    public static void main(String[] args) {
        MyLinkedList1 list1 = new MyLinkedList1();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1);

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
            } else {
                node.previous = last;
                node.next = null;
                last.next = node;
                last = node;
            }

        }
    }

