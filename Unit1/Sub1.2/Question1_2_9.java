import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.Counter;

/**
 * Author: Sangs 
 * Date:2020.12.22
 * Function:《算法》P71 1.2.9
 * Questiion:修改BinarySearch，使用Counter统计在有查找中被检查的键的总数并在查找全部结束后打印该值
 * Ps.在main()中创建一个Counter对象并将它作为参数传递给rank()
 */
public class Question1_2_9 {
    
    public static int BinarySearch(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length-1;
        while(lo <=hi){
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) {hi = mid - 1; counter.increment();}
            else if(key > a[mid]) {lo = mid + 1; counter.increment();}
            else{
                counter.increment();
                System.out.print("查找到了");
                return counter.tally();
            } 
        }
        System.out.print("没找到");
        return counter.tally();
    }


    public static void main(String[] args) {
        Counter counter = new Counter("counter");
        System.out.print("输入数字个数：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("输入数字序列：");
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.print("输入要查找的值：");
        int key = sc.nextInt();
        sc.close();
        
        int fin = BinarySearch(key, arr, counter);
        System.out.printf("总共查找了%d次", fin);
    }
}
