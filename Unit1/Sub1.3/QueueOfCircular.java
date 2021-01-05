import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.5 
 * Function:《算法》P103 1.3.29 
 * Questiion:用环形链表实现Queue,
 *           环形链表也是一种链表，只是没有任何节点的连接为空,
 *           且只要链表非空则last.next的值为first 只能用一个Node类型的实例变量(last)
 * Ps. 想试试用jar包中的StdIn和StdOut，但是失败了，也懒得继续找解决办法了
 */
public class QueueOfCircular <Item> implements Iterable<Item>{
    private int N;
    private Node last;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) last.next = last;
        else
        {
            last.next = oldlast.next;
            oldlast.next = last;
        }

        N++;
    }
    public Item dequeue(){
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }
    public Iterator<Item> iterator(){return new ListIterator();}
    private class ListIterator implements Iterator<Item>{
        private Node current = last.next;
        public boolean hasNext(){return current != last.next;}
        public void remove(){};
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        QueueOfCircular<String> q = new QueueOfCircular<String>();
        System.out.print("输入一些字符串以空格分隔，最后用Ctrl + z + Enter结束输入：");
        while(true){
            if (sc.hasNext()){
                s = sc.next();
                q.enqueue(s);
            }
            else break;
        }
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
        sc.close();
    }
}
