import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.6 
 * Function:《算法》P104 1.3.32
 * Questiion:一个以栈为目标的队列，是一种支持push、pop和enqueue操作的数据类型
 *          为这种抽象数据类型定义一份API并给出一份基于链表的实现
 * Ps。 输入一些字符串，中间带上 '-' ，如果遇到了 '-'就把pop一下然后再push
 */
public class Steque<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private int N;
    private Node first;
    private Node last;

    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    public void push(Item item){
        // 栈为空是否需要考虑
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        // 栈为空是否需要考虑
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {return new ListIterator();}
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
        Steque<String> sq = new Steque<String>();
        System.out.print("输入一系列字符串，空格分隔进行入队列操作,结束输入使用ctrl + z + enter：");
        Scanner sc = new Scanner(System.in);
        String s;
        while (true){
            if (sc.hasNext()) s = sc.next();
            else break;
            if(!s.equals("-")) sq.enqueue(s);
            else {
                String temp = sq.pop();
                sq.push(temp);
            }
        }
        sc.close();
        System.out.print("最后Stque中的元素为：");
        for(String item : sq){
            System.out.print(item + " ");
        }
    }
}
