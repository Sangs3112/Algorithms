/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P101 1.3.1
 * Questiion:为FixedCapacityStackOfStrings添加一个方法isFull()
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }
    public boolean isEmpty(){return N == 0;}
    public boolean isFull(){return N == a.length;}
    public int size(){return N;}
    public void push(String item){a[N++] = item;}
    public String pop(){return a[--N];}
}
