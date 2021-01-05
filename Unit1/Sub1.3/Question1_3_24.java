/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.24
 * Questiion:编写一个方法removeAfter(),接收一个链表节点作为参数并删除该节点的后续节点
 *          (如果参数节点或参数节点的后续节点为空则什么也不做)
 */
public class Question1_3_24 {
    public class Node{
        int item;
        Node next;
    }
    
    public static void removeAfter(Node x) {
        if(x.next != null && x != null)
            x.next = x.next.next;
    }
}
