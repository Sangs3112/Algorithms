import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.10
 * Function:《算法》P35 1.1.27
 * Questiion:改写binomial递归算法为更高效的算法
 * public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1, p);
    }
 */
public class Question1_1_27 {

    public static double binomialBetter(int N, int k, double p) {
        double[][] arr = new double[N+1][k+1];
        arr[0][0] = 1.0;
        for (int i=1; i<N+1; i++)
            arr[i][0] = arr[i-1][0]*(1.0-p);
        for (int i = 1; i<N+1; i++){
            for (int j=1; j<k+1; j++)
                arr[i][j] = p*arr[i-1][j-1] + (1.0-p)*arr[i-1][j];
        }
        return arr[N][k];
    }


    public static void main(String[] args) {
        System.out.print("输入二项分布独立实验总次数、成功次数、成功一次概率，空格分隔：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        double p = sc.nextDouble();
        sc.close();
        double fin = binomialBetter(N, k, p);
        System.out.println(fin);
    }
}
