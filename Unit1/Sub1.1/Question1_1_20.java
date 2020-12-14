import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P35 1.1.20
 * Questiion:编写一个递归的静态方法计算ln(N!)的值
 */
public class Question1_1_20 {
    public static long factorial(int N) {
        if(N == 0 || N == 1) return 1;
        return factorial(N-1)*N;
    }

    public static void main(String[] args) {
        System.out.print("输入数据N：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        double k = Math.log(factorial(N));
        System.out.printf("ln(%d!)的结果是：%f",N,k);
    }
}
