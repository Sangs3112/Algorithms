/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.25
 * Questiion:编写一个方法insertAfter(),接收两个链表节点作为参数
 *          将第二个节点插入链表并使之成为第一个节点的后续节点
 *          (如果两个参数为空则什么也不做)
 * Ps 不确定是否正确，尤其是这个this用法，我是想修改全局变量链表first的，但是不知道对不对，感觉写测试代码好麻烦
 */
public class Question1_3_25 {
    public class Node{
        int item;
        Node next;
    }

    private Node first;

    public void insertAfter(Node x, Node y){
        if (x != null && y != null){
            Node temp = this.first;
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
}
