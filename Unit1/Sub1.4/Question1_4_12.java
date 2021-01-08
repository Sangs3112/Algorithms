import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.8
 * Function:《算法》P132 1.4.12
 * Questiion:编写一个程序，有序打印给定的两个有序数组(含有N个int值)中的所有公共元素
 *          程序在最坏的情况下所需的运行时间应该和logN成正比
 */
public class Question1_4_12 {

    public static int binarySearch(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = (hi - lo)/2 + lo;
            if(a[mid] > key) hi = mid - 1;
            else if(a[mid] < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.print("输入两个随机整数数组的大小：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[] a = new int[N];
        int[] b = new int[N];
        Random r = new Random();
        for(int i = 0; i < N; i++){
            a[i] = r.nextInt(111);
            b[i] = r.nextInt(111);
        }

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.print("两个随机数组中的元素分别为：\n");
        for(int num : a){
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : b){
            System.out.print(num + " ");
        }
        System.out.println();

        // 开始借助二分查找完成算法
        System.out.print("两个数组中公共元素有：");
        for(int i = 0; i < N; i++){
            if(binarySearch(b, a[i]) > -1 && a[i] != a[i-1]) System.out.print(a[i] + " ");
        }
    }
}
