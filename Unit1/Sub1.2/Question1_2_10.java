import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.22
 * Function:《算法》P71 1.2.10
 * Questiion:编写一个类VisualCounter，支持加一和减一操作。它的构造函数接收两个参数N和max
 *          其中N指定了最大操作次数，max指定了计数器的最大绝对值。
 *          作为副作用，用图像显示每次计数器变化后的值
 */
public class Question1_2_10 {


    public static void main(String[] args) {
        System.out.print("输入操作最大次数和计数器最大绝对值，空格分开：");    
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = sc.nextInt();
        sc.close();
        VisualCounter vc = new VisualCounter(N, max);
        Random r = new Random();

        while(!vc.isEnd()){
            int temp = r.nextInt();
            if(temp % 2 == 0)
                vc.increment();
            else
                vc.decreament();
            vc.Draw();
        }
    }
}
