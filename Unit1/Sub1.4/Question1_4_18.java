import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.8 
 * Function:《算法》P133 1.4.18
 * Questiion:数组的局部最小元素,编写一个程序,给定一个含有N个不同整数的数组,找到一个局部最小元素
 *          满足：a[i] < a[i-1]，且a[i]<a[i+1]的索引i
 *          程序在最坏情况下所需的比较次数为~2lgN
 * Ps.检查数组的中间值a[N/2]以及和它相邻的元素a[N/2-1]和a[N/2+1]
 *    如果a[N/2]是一个局部最小值则算法终止;否则在较小的相邻元素的半边中继续查找
 */
public class Question1_4_18 {
    
    public static int localMinOfArray(int[] a) {
        int lo = 0;
        int hi = a.length -1;
        while(lo <= hi){
            int mid = (hi - lo)/2 + lo;
            if(a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) return mid;
            else{
                if(a[mid - 1] < a[mid + 1]) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        return -1;
    }
    

    public static void main(String[] args) {
        System.out.print("输入随机整数数组的大小：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] a = new int[N];
        Random r = new Random();
        for(int i = 0; i < N; i++)
            a[i] = r.nextInt(N);
        System.out.print("随机数组的值为：");
        for(int temp : a)
            System.out.print(temp + " ");
        
        int fin = localMinOfArray(a);
        if (fin == -1) System.out.println("没有局部最小值");
        else System.out.println("其中一个局部最小值的索引为：" + fin);
    }
}
