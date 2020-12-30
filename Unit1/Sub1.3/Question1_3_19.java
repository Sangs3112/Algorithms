import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P103 1.3.19
 * Questiion:编写一段代码，删除链表的尾节点，其中链表的首节点为first
 */
public class Question1_3_19 {
    private class Node{
        int item;
        Node next;
    }
    private Node first;

    private void deleteLastNode(){
        Node current = first;
        if(current == null) return ;
        Node next = current.next;
        if (next == null) first = null;
        while (next.next != null){
            current = next;
            next = next.next;
        }
        current.next = null;
    }
}
