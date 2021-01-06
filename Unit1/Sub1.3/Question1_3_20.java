import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.20
 * Questiion:编写一个方法delete()，接收一个int参数k，删除链表的第k个元素，如果存在的话
 * Ps.索引大于链表中节点的个数会出现异常还没有处理
 */
public class Question1_3_20 {
    public static class Node{
        int item;
        Node next;
    }

    private static Node first;

    public static void delete(int k) {
        if (k >1){
            Node current = first;
            int temp = 1;
            while (current != null) {
                if (temp == k - 1) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
                temp++;
            }
        }else if(k == 1){
            first = first.next;
        }else{
            throw new Error("索引不对！");
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
        System.out.println("\n输入需要删除的元素整数索引，从1开始：");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        delete(k);
        System.out.print("\n删除指定链表索引节点后的值为：");
        Node y = first;
        while (y != null){
            System.out.print(y.item + " ");
            y = y.next;
        }
    }
}
