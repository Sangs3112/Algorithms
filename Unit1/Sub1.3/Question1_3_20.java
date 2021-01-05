/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.20
 * Questiion:编写一个方法delete()，接收一个int参数k，删除链表的第k个元素，如果存在的话
 */
public class Question1_3_20 {
    public class Node{
        int item;
        Node next;
    }

    private Node first;

    public void delete(int k ){
        Node x = first;
        int i = 1;
        while (true){
            if (i == k - 1){
                x = x.next;
                x.next = x.next.next;
                break;
            }
            i++;
        }
    }
}
