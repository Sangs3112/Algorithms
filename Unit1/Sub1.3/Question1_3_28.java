/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.28
 * Questiion:编写一个方法max(),接收一个链表的首节点作为参数,返回链表中键最大的节点的值
 *          假设所有的键均为正数,如果链表为空则返回0,用递归解
 */
public class Question1_3_28 {
    public class Node{
        int item;
        Node next;
    }

    public static int max(Node first) {
        if(first == null || first.next == null)
            return first.item;
        if(first.next.item > first.item){
            return max(first.next);
        }
        return max(first);
    }
}
