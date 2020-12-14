import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.13
 * Function:《算法》P37 1.1.36
 * Questiion:乱序检查，编写一个程序ShuffleTest，接受命令行参数M和N
 *          将大小为M的数组打乱N次并且在每次打乱之前都将数组重新初始化为a[i]=i，
 *          打印一个M*M的表格，对于所有的列j，行i表示的都是i在打乱后落到j的位置的次数
 *          数组中所有的元素都应该接近于N/M
 */
public class Question1_1_36 {
    
    public static void shuffle(int[] a) {//随机排列
        int N = a.length;
        Random ran = new Random();
        for (int i=0; i<N; i++){
            int r = i +ran.nextInt(N-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int[][] ShuffleTest(int M, int N) {
        int[] a = new int[M];
        int[][] fin = new int[M][M];
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++)
                a[j] = j;
            shuffle(a);
            for(int j=0; j<M; j++)
                fin[j][a[j]]++;
        }
        return fin;
    }


    public static void main(String[] args) {
        System.out.print("输入数组大小和打乱次数，空格分隔：");
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        int[][] fin = ShuffleTest(M, N);
        System.out.println("输出的二维数组是：");
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++)
                System.out.printf(" %d ", fin[i][j]);
            System.out.println("");
        }
    }
}
