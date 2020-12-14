import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P35 1.1.22
 * Questiion:使用递归方法实现BinarySearch并跟踪该方法的调用
 */
public class Question1_1_22 {

    public static int rank(int[] a, int key, int lo, int hi){
        int mid = lo + (hi - lo)/2;
        while(lo <= hi){
            if (key < mid) return rank(a, key, lo, mid - 1);
            else if (key > mid) return rank(a, key, mid + 1, hi);
            else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入数组元素个数：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("输入数组元素，用空格分隔：");
        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();
        System.out.print("输入要查找的值：");
        int key = sc.nextInt();

        Arrays.sort(arr);
        System.out.print("排序后的数组为：[");
        for (int i = 0;i < n;i++)
            System.out.printf(" %d ",arr[i]);
        System.out.print("]");

        int fin = rank(arr, key, 0, n - 1);
        if(fin >=0)
            System.out.printf("\n%d在排序后的数组中第%d位",key,fin);
        else
            System.out.println("未找到");
        sc.close();
    }
    
}
