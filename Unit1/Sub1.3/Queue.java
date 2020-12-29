import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2020.12.29 
 * Function:先进先出队列
 *          boolean isEmpty() 判断是否为空 
 *          int size() 返回队列的大小 
 *          void enqueue(Item item) 表尾添加元素
 *          Item dequeue() 表头删除元素
 * SampleIn:to be or not to - be - - that - - - is
 * SampleOut:to be or not to be 最后队列中还有2个元素
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;//最早添加的元素
    private Node last;//最近添加的元素
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {return first == null;}
    public int size() {return N;}
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){return new ListIterator();}
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){return current != null;}
        public void remove(){}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        System.out.print("输入一些字符串，中间用空格分隔，用ctrl + z + Enter结束输入：");
        Scanner sc = new Scanner(System.in);
        String s;
        Queue<String> q = new Queue<String>();
        while(true){
            if(sc.hasNext()) s = sc.next();
            else break;
            if(!s.equals("-")) q.enqueue(s);
            else if(!s.isEmpty()) System.out.print(q.dequeue() + " ");
        }
        sc.close();
        System.out.printf("最后队列中还有%d个元素", q.size());
    }
}
