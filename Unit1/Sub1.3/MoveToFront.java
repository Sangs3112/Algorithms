import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.7 
 * Function:《算法》P106 1.3.37
 * Questiion:前移编码。从标准输入读取一段字符，使用链表保存这些字符并清除重复字符 
 *          当你读取了一个从未见过的字符时，将它插入表头
 *          当你读取了一个重复的字符时，将它从链表中删去并在其插入表头 
 *          这种策略假设最近访问过的元素很可能会再次访问，因此可以用于缓存、数据压缩等许多场景
 */
public class MoveToFront {
    private static class Node {
        String item;
        Node next;
    }

    private static int N;
    private static Node first;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 输入一个字符，删除链表中所有相同字符的节点
     */
    public static void deleteItem(String key) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(key)) {
                if (current == first) {
                    first = first.next;
                    current = first;
                    continue;
                }
            } else if (current.next != null) {
                if (current.next.item.equals(key)) {
                    current.next = current.next.next;
                    continue;
                } else {
                    current = current.next;
                    continue;
                }
            }
            current = current.next;
        }
    }

    /**
     * 接收一个字符，创建这个字符的节点，然后将节点从链表头插入
     */
    public static void insertFront(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public static void main(String[] args) {
        System.out.print("输入一系列字符，中间用空格分隔，用ctrl + z + Enter结束：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Node temp = new Node();
        temp.item = s;
        temp.next = null;
        first = temp;
        while (true) {
            if (sc.hasNext())
                s = sc.next();
            else
                break;
            deleteItem(s);
            insertFront(s);
        }
        sc.close();
        Node current = first;
        System.out.print("最后链表中的值为：");
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }
}
