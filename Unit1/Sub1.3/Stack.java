import java.util.Iterator;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2020.12.29 
 * Function:下压栈
 *          boolean isEmpty() 判断是否为空 
 *          int size() 返回栈的大小 
 *          void push(Item item) 入栈
 *          Item pop() 出栈
 * SampleIn:to be or not to - be - - that - - - is
 * SampleOut:to be or not to be 堆栈中还有2个元素
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() {return first == null;}
    public int size() {return N;}
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
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
        Stack<String> st = new Stack<String>();
        System.out.print("输入一些字符串，中间用空格分隔,最后用ctrl + z + Enter结束：");
        Scanner sc = new Scanner(System.in);
        String s;
        while(true){
            if(sc.hasNext()) s =sc.next();
            else break;
            if (!s.equals("-")) st.push(s);
            else if(!st.isEmpty()) System.out.print(st.pop() + " ");
        }
        sc.close();
        System.out.printf("堆栈中还有%d个元素", st.size());
    }
}
