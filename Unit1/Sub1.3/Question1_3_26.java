/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.26
 * Questiion:编写一个方法remove(),接收一个链表和一个字符串key作为参数,删除链表中所有item域为key的节点
 */
public class Question1_3_26 {
    public class Node{
        String item;
        Node next;
    }

    public static void remove(Node first, String key){
        Node x = first;
        while (x.next != null){
            if (x.item.equals(key)){
                first = x.next;
                x.next = null;
            }  
            if(x.next.item.equals(key)) x.next = x.next.next;
            else if(x.next.next == null && x.next.item.equals(key)) x.next = null;
            else x = x.next;
        }
    }
}
