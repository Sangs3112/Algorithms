import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:二分查找循环实现
 */

public class binarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
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

        int fin = rank(key, arr);
        if(fin >=0)
            System.out.printf("\n%d在排序后的数组中第%d位",key,fin+1);
        else
            System.out.println("未找到");
        sc.close();
    }
}
