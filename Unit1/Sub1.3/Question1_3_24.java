import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.24
 * Questiion:编写一个方法removeAfter(),接收一个链表节点作为参数并删除该节点的后续节点
 *          (如果参数节点或参数节点的后续节点为空则什么也不做)
 */
public class Question1_3_24 {
    public static class Node{
        int item;
        Node next;
    }
    
    private static Node first;

    public static void removeAfter(Node x) {
        if(x.next != null && x != null)
            x.next = x.next.next;
    }


    public static void main(String[] args) {
        Node fi = new Node();
        Node se = new Node();
        Node th = new Node();
        Node fo = new Node();
        fi.item = 1; se.item = 2; th.item = 3; fo.item = 4;
        fi.next = se; se.next = th; th.next = fo; fo.next = null;
        first = fi;

        Node x = first;
        System.out.print("初始链表值为：");
        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }
        System.out.print("输入其中一个节点的值:");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.close();
        Node y = first;
        while(y != null){
            if (y.item == key) break;
            else y = y.next;
        }
        if (y.next == null){
            if (y.item == key) removeAfter(y);
            else System.out.println("没有这个节点");
        }else removeAfter(y);

        System.out.print("删除指定节点后的链表为；");
        Node z = first;
        while(z != null){
            System.out.print(z.item + " ");
            z = z.next;
        }
    }
}
