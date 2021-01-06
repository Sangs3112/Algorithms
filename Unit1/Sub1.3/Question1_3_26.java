import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.26
 * Questiion:编写一个方法remove(),接收一个链表和一个字符串key作为参数,删除链表中所有item域为key的节点
 */
public class Question1_3_26 {
    private static class Node{
        String item;
        Node next;
    }

    public static Node remove(Node head, String key){
        if(head != null && head.item.equals(key)) head = head.next;
        Node current = head;
        while(current.next != null){
            if(current.next.item.equals(key)) current.next = current.next.next;
            current = current.next;
            // if (current.next.next == null){
            //     if(current.item.equals(key)) current.next = current.next.next;
            // }
        }
        return head;
    }


    public static void main(String[] args) {
        Node fi = new Node();
        Node se = new Node();
        Node th = new Node();
        Node fo = new Node();
        fi.item = "ab"; se.item = "bc"; th.item = "ab"; fo.item = "cd";
        fi.next = se; se.next = th; th.next = fo; fo.next = null;

        Node x = fi;
        System.out.print("初始链表值为：");
        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }

        System.out.print("\n输入要删除的节点的值：");
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        sc.close();

        Node z = remove(fi, key);
        System.out.print("删除指定节点后的链表为；");
        while(z != null){
            System.out.print(z.item + " ");
            z = z.next;
        }
    }
}
