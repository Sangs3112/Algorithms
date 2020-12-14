import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P34 1.1.13
 * Questiion:编写一段代码，打印出一个M行N列的二维数组的转置
 */
public class Question1_1_13 {
    
    public static void main(String[] args) {
        System.out.print("输入矩阵的行列数，空格分隔：");
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        Random r = new Random();
        int[][] arr = new int[M][N];//初始矩阵
        int[][] fin = new int[N][M];//转置矩阵

        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++)
                arr[i][j] = r.nextInt(10);//0~9之间的随机数
        }
        System.out.printf("%d*%d大小的初始矩阵为：\n",M,N);
        for (int i = 0; i<M; i++){
            System.out.print("[");
            for(int j = 0; j<N; j++)
                System.out.printf(" %d ",arr[i][j]);
            System.out.print("]\n");
        }

        for(int i = 0; i<M; i++){
            for (int j = 0; j<N; j++){
                fin[j][i] = arr[i][j];
            }
        }
        System.out.println("其转置矩阵为：");
        for (int i = 0; i<N; i++){
            System.out.print("[");
            for(int j = 0; j<M; j++)
                System.out.printf(" %d ",fin[i][j]);
            System.out.print("]\n");
        }
    }
}
