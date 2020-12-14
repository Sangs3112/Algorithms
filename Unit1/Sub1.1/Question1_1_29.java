import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.10
 * Function:《算法》P35 1.1.29
 * Questiion:等值键，BinarySearch有个静态方法rank()
 * 接受一个键和一个整型有序数组，(可能存在重复键)作为参数
 * 并返回小于该键的元素数量，
 * 还有一个类似的方法count()来返回数组中等于该键的元素数量
 * P.S 如果i和j分别是rank(key, a)和count(key, a)的返回值
 *      那么a[i..i+j-1]就是数组中所有和key相等的元素
 */
public class Question1_1_29 {
    
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(key<a[mid]) hi = mid - 1;
            else if(key>a[mid]) lo = mid + 1;
            else {
                while(mid-1>=0 && a[mid-1] == key)
                    mid--;
                return mid;
            }
        }
        return -1;
    }

    public static int count(int key, int[] a) {
        int temp = rank(key, a);
        int tempr = temp;
        if(temp == -1) return -1;
        while(tempr+1<=a.length-1 && a[tempr+1] == key)
            tempr++;
        return tempr-temp+1;
    }


    public static void main(String[] args) {
        System.out.print("输入数组元素个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("输入数组内各个元素的值，用空格分隔：");
        for (int i=0; i<n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);

        System.out.print("输入要查找的键值：");
        int key = sc.nextInt();
        sc.close();

        int fin1 = rank(key, a);
        int fin2 = count(key, a);
        if (fin1==-1)
            System.out.println("未找到该数据");
        else{
            System.out.print("排序后的数组为：[");
            for (int i=0; i<n; i++)
                System.out.printf(" %d ",a[i]);
            System.out.print("]");
            System.out.printf("\n其中共有%d个元素小于%d",fin1,key);
            System.out.printf("\n与%d的值相等的元素有%d个",key,fin2);
        }
    }
}
