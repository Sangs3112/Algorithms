/**
 * Author: Sangs 
 * Date:2021.1.5 
 * Function:《算法》P103 1.3.19
 * Questiion:编写一段代码，删除链表的尾节点，其中链表的首节点为first
 */
public class Question1_3_19{
    public static class Node{
        int item;
        Node next;
    }

    public static void deleteLastNode(Node first) {
        if (first == null) return;// 空链表
        if (first.next == null) first = null;// 链表只有首节点

        // 链表至少两个节点
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public static void main(String[] args) {
        Node fi = new Node();
        Node se = new Node();
        Node th = new Node();
        Node fo = new Node();
        fi.item = 1; se.item = 2; th.item = 3; fo.item = 4;
        fi.next = se; se.next = th; th.next = fo; fo.next = null;

        Node x = fi;
        System.out.print("初始链表值为：");
        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }
        deleteLastNode(fi);
        System.out.print("\n删除链表尾节点后的值为：");
        Node y = fi;
        while (y != null){
            System.out.print(y.item + " ");
            y = y.next;
        }
    }

}
