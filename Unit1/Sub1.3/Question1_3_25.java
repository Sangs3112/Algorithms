import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.25
 * Questiion:编写一个方法insertAfter(),接收两个链表节点作为参数
 *          将第二个节点插入链表并使之成为第一个节点的后续节点
 *          (如果两个参数为空则什么也不做)
 */
public class Question1_3_25 {
    public static class Node{
        int item;
        Node next;
    }

    private static Node first;

    public static void insertAfter(Node x, Node y){
        if (x != null && y != null){
            Node temp = first;
            while(temp.next != null){
                if (temp.item == x.item){
                    Node t = temp.next;
                    temp.next = y;
                    y.next = t;
                    break;
                }
                temp = temp.next;
            }
            // 查找到了最后一个,并且最后一个节点就是x
            if(temp.item == x.item){
                temp.next = y;
            }
        }
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
        System.out.print("输入要在哪个数字后面插入新节点：");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.print("输入要插入的节点的值：");
        int item = sc.nextInt();
        sc.close();
        Node node = new Node();
        node.item = item;

        Node y = first;
        while(y != null){
            if (y.item == key) break;
            else y = y.next;
        }
        if (y.next == null){
            if (y.item == key) insertAfter(y, node);
            else System.out.println("没有这个节点");
        }else insertAfter(y, node);

        System.out.print("插入指定节点后的链表为；");
        Node z = first;
        while(z != null){
            System.out.print(z.item + " ");
            z = z.next;
        }
    }
}
