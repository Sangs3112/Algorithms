import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Author: Sangs 
 * Date:2021.1.5 
 * Function:《算法》P104 1.3.31
 * Questiion:实现一个嵌套类DoubleNode用来构造双向链表，
 *          其中每个节点都含有一个指向前驱元素的引用和一项指向后级元素的引用(如果不存在则为null)
 *          为以下任务实现若干静态方法：在表头插入节点、在表尾插入节点、从表头删除节点、从表尾删除节点
 *          在指定节点之前插入节点、在指定节点之后插入节点、删除指定节点
 * Ps.心态崩了，链表不会，照着网上的打一遍结果报了七八个错误，然后自己把网上的复制下来能运行，但是有30个警告看着属实难受就这样吧，链表还是要看，不然不会做可不行，这些题目感觉都有点东西，还是我太菜了
 */
public class DoubleNode<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item>{
        private Node<Item> previous;
        private Item item;
        private Node<Item> subsequent;

        public Node() {
            previous = null;
            subsequent = null;
        }
    }

    public DoubleNode() {
        first = null;
        last = null;
        n = 0;
    }
    public int getN() { return n; }

    public boolean isEmpty(){ return  n ==  0;}

    /**表头插入结点
     * @param item
     */
    public void Head_add(Item item){
        Node<Item> newHead = new Node<>();
        newHead.item = item;
        if (isEmpty()){
            first = newHead;
            last = first;
        }
        else {
            newHead.subsequent = first;
            first.previous = newHead;
            first = newHead;
        }
        n++;
    }

    /**表尾插入结点
     * @param item
     */
    public void Tail_add(Item item){
        Node<Item> newTail = new Node<>();
        newTail.item =  item;
        if (isEmpty()){
            last = newTail;
            first = last;
        }
        else {
            newTail.previous = last;
            last.subsequent = newTail;
            last = newTail;
        }
        n++;
    }

    public Item deleteHead(){
        if (isEmpty()) throw new NoSuchElementException("No Node");
        Item item = first.item;

        first = first.subsequent;
        first.previous = null;
        n--;
        return item;
    }

    public Item deleteTail(){
        if (isEmpty()) throw new NoSuchElementException("No Node");
        Item item = last.item;
        n--;
        last = last.previous;
        last.subsequent = null;
        return item;
    }

    public boolean insertBeforeSpecific(Item Key,Item insertItem){
        if(n == 0){
            return false;
        }
        Node newnode = new Node();
        newnode.item = insertItem;

        Node current = first;
        while (current != null){
            if (current.item.equals(Key)){
                if (current.previous == null){
                    current.previous = newnode;
                    newnode.subsequent = current;
                    first = newnode;
                }
                else {
                    current.previous.subsequent = newnode;
                    newnode.subsequent = current;
                    newnode.previous = current.previous;
                    current.previous = newnode;
                }
                n++;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;
    }

    public boolean insertAfterSpecific(Item Key,Item insertItem){
        if(n == 0){
            return false;
        }
        Node newnode = new Node();
        newnode.item = insertItem;

        Node current = first;
        while(current != null){
            if (current.item.equals(Key)){
                if (current.subsequent == null){
                    current.subsequent = newnode;
                    newnode.previous = current;
                    last = newnode;
                }
                else {
                    current.subsequent.previous = newnode;
                    newnode.subsequent = current.subsequent;
                    current.subsequent = newnode;
                    newnode.previous = current;
                }
                n++;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;

    }

    public boolean deleteSpecific(Item Key){
        if(n == 0){
            return false;
        }
        Node current = first;
        while(current.subsequent != null) {
            if (current.item.equals(Key)){
                if (current.previous == null){
                    first = first.subsequent;
                    first.previous = null;
                }
                else if (current.subsequent == null){
                    last = last.previous;
                    last.subsequent = null;
                }
                else {
                    current.previous.subsequent = current.subsequent;
                    current.previous.subsequent.previous = current.previous;
                }
                n--;
                return true;
            }
            else {
                current = current.subsequent;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> test = new DoubleNode<>();
        test.Head_add(1);
        //-1-
        if (test.insertBeforeSpecific(1,3)) System.out.println("insert correctly");
        else System.out.println("error");
        //-3<=>1-
        if (test.insertAfterSpecific(1,4)) System.out.println("insert correctly");
        else System.out.println("error");
        //-3<=>1<=>4-
        test.Head_add(2);
        //-2<=>3<=>1<=>4-
        if (test.deleteSpecific(1)) System.out.println("delete correctly");
        else System.out.println("error");
        //-2<=>3<=>4-
        test.Tail_add(9);
        //-2<=>3<=>4<=>9-
        test.Tail_add(10);
        //-2<=>3<=>4<=>9<=>10-
        test.deleteHead();
        //-3<=>4<=>9<=>10-
        test.deleteTail();
        //-3<=>4<=>9-
        System.out.println(test.first.item);
    }
}