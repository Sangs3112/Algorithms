import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P34 1.1.15
 * Questiion:编写一个静态方法histogram(),接收一个整型数组a[]和一个整数M为参数
 * 并返回一个大小为M的数组，其中仅第i个元素为整数i在参数数组中出现的次数。
 * 如果a[]中的值均在0到M-1之间，返回数组中的所有元素之和应该和a.length相等
 */
public class Question1_1_15 {
    
    public static int[] histogram(int[] a, int M) {
        int[] fin = new int[M];
        for(int i = 0; i<M; i++)
            fin[a[i]]++;
        return fin;
    }


    public static void main(String[] args) {
        System.out.print("输入数组的大小：");
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] a = new int[M];
        Random r = new Random();
        for(int i = 0; i<M; i++)
            a[i] = r.nextInt(M);

        System.out.print("原随机数组为：[");
        for(int i = 0; i<M; i++)
            System.out.printf(" %d ",a[i]);
        System.out.print("]\n");

        int[] fin = histogram(a, M);

        System.out.print("按照要求生成的数组为：[");
        for(int i = 0; i<M; i++)
            System.out.printf(" %d ",fin[i]);
        System.out.print("]");
        sc.close();
    }
}
