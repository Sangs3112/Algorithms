/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.21
 * Questiion:编写一个方法find(),接收一个链表和一个字符串key作为参数。
 *          如果链表中的某个节点item域的值为key,方法返回true,否则返回false。
 */
public class Question1_3_21 {
    public class Node{
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
}
