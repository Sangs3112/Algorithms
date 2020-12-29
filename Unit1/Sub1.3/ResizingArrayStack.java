import java.util.Iterator;

/**
 * Author: Sangs 
 * Date:2020.12.29 
 * Function:下压栈，后进先出，动态调整数组大小的实现 
 *          boolean isEmpty() 判断是否为空 
 *          int size() 返回栈的大小 
 *          void resize(int max) 将栈移动到一个大小为max的新数组(栈) 
 *          void push(Item item) 入栈 
 *          Item pop() 出栈
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N;
    
    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}
    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    public void push(Item item){
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null;//避免孤儿游离
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<Item>{
        //支持先进后出的迭代
        private int i = N;
        public boolean hasNext() {return i > 0;}
        public Item next() {return a[--i];}
        public void remove(){}
    }
}
