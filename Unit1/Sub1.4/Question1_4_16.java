import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.8
 * Function:《算法》P133 1.4.16
 * Questiion:最接近的一对(一维),编写一个程序,给定含有N个double值的数组a[],
 *          在其中找到一对最接近的值：两者之差(绝对值)最小的两个数。
 *          程序在最坏的情况下所需的运行时间应该是线性对数级别的
 */
public class Question1_4_16 {
    

    public static void main(String[] args) {
        System.out.print("输入随机小数数组的大小：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        double[] a = new double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            a[i] = r.nextDouble();
        System.out.print("小数随机数组中的元素为：");
        for(double item: a)
            System.out.print(item + " ");
        
        Arrays.sort(a);
        double min = 99;
        int temp = 0;
        for (int i = 0; i < N - 1; i++) {
            if (min > a[i + 1] - a[i]) {
                min = a[i + 1] - a[i];
                temp = i;
            }
        }
        System.out.print("\n最接近的一对是：" + a[temp] + " " + a[temp + 1]);
    }
}
