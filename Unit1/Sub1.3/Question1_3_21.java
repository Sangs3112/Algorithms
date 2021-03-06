import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.21
 * Questiion:编写一个方法find(),接收一个链表和一个字符串key作为参数。
 *          如果链表中的某个节点item域的值为key,方法返回true,否则返回false。
 */
public class Question1_3_21 {
    public static class Node{
        String item;
        Node next;
    }

    public static boolean find(Node first, String key) {
        Node x = first;
        while (x.next != null){
            if (x.item.equals(key)) return true;
            x = x.next;
        }
        if (x.item.equals(key)) return true;
        return false;
    }


    public static void main(String[] args) {
        Node fi = new Node();
        Node se = new Node();
        Node th = new Node();
        Node fo = new Node();
        fi.item = "ab"; se.item = "bc"; th.item = "cd"; fo.item = "de";
        fi.next = se; se.next = th; th.next = fo; fo.next = null;
        System.out.print("初始链表值为：");
        Node x = fi;
        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }
        System.out.print("\n输入要查找的字符串：");
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        sc.close();
        if(find(fi, key)) System.out.println("查找到了");
        else System.out.println("没有找到");
    }
}
