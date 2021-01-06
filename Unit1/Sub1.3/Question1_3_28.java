/**
 * Author: Sangs
 * Date:2021.1.5
 * Function:《算法》P103 1.3.28
 * Questiion:编写一个方法max(),接收一个链表的首节点作为参数,返回链表中键最大的节点的值
 *          假设所有的键均为正数,如果链表为空则返回0,用递归解
 */
public class Question1_3_28 {
    private static class Node{
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


    public static void main(String[] args) {
        Node fi = new Node();
        Node se = new Node();
        Node th = new Node();
        Node fo = new Node();
        fi.item = 1; se.item = 2; th.item = 3; fo.item = 4;
        fi.next = se; se.next = th; th.next = fo; fo.next = null;

        Node vo = new Node();// 空节点测试
        
        Node x = fi;
        System.out.print("初始链表值为：");
        while (x != null) {
            System.out.print(x.item + " ");
            x = x.next;
        }

        int fin = max(fi);
        System.out.println("\n链表中各个节点最大值为：" + fin);
        System.out.println("空链表调用函数的返回值为：" + max(vo));
    }
}
