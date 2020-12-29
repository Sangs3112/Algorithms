import java.util.Iterator;

/**
 * Author: Sangs Date:2020.12.29 Function:背包，后进先出 boolean isEmpty() 判断是否为空 int
 * size() 返回栈的大小 void add(Item item) SampleIn:to be or not to - be - - that - -
 * - is SampleOut:to be or not to be 最后队列中还有2个元素
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return first == null;}
    public int size() {return N;}
    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
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
}
