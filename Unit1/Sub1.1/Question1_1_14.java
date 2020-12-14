import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P34 1.1.14
 * Questiion:编写一个静态方法lg(),接收一个整型参数N,返回不大于1og2N的最大整数,不能使用Math库
 */
public class Question1_1_14 {

    public static int lg(int N) {
        int k = -1;
        int M = 1;
        while(M<=N){
            M*=2;
            k++;
        }
        return k;
    }


    public static void main(String[] args) {
        System.out.print("输入一个数：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int ans = lg(N);
        System.out.printf("不大于log2 %d的最大整数是：%d",N,ans);
    }
}
