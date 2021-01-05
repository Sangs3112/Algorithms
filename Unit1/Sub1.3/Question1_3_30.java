/**
 * Author: Sangs 
 * Date:2021.1.5 
 * Function:《算法》P103 1.3.30
 * Questiion:编写一个函数，接收一个链表的首节点作为参数(破坏性地)将链表反转并返回结果链表的首节点
 * Ps.为了完成这个任务，我们需要记录链表中的三个连续节点:reverse、first和second。
 *    在每轮迭代中，我们从原链表中提取节点first并将它插入到逆链表的开头
 *    我们需要一直保持first指向原链表中所有剩余节点的首节点，
 *    second指向原链表中所有剩余节点的第二个节点，
 *    reverse指向结果链表中的首节点
 * 不知道为什么递归解法最后会多输出一个1
 */
public class Question1_3_30 {
    public static class Node<Item>{
        public Item item;
        public Node<Item> next;
    }

    public static Node<Integer> iterationReverse(Node<Integer> head){
        Node<Integer> reverse = null;
        Node<Integer> first = head;
        while(first != null){
            Node<Integer> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public static Node<Integer> recursionReverse(Node<Integer> head){
        if (head == null) return null;
        if (head.next == null) return head;
        Node<Integer> second = head.next;
        Node<Integer> rest = recursionReverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }


    public static void main(String[] args) {
        Node<Integer> fi = new Node<Integer>();
        Node<Integer> se = new Node<Integer>();
        Node<Integer> th = new Node<Integer>();
        Node<Integer> fo = new Node<Integer>();
        fi.item = 1;
        se.item = 2;
        th.item = 3;
        fo.item = 4;
        fi.next = se;se.next = th;th.next = fo;fo.next = null;
        Node<Integer> test = iterationReverse(fi);
        Node<Integer> x = test;
        while(x != null){
            System.out.print(x.item + " ");
            x = x.next;
        }
        System.out.println();
        Node<Integer> test2 = recursionReverse(test);
        Node<Integer> y = test2;
        while(y != null){
            System.out.print(y.item + " ");
            y = y.next;
        }
        System.out.println(test2.item);
    }
}
