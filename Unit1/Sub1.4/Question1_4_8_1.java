import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2021.1.7
 * Function:《算法》P132 1.4.8
 * Questiion:编写一个程序,计算输入中相等的整数对的数量。
 *           如果你的第一个程序是平方级别的，请继续思考并用Array.sort()给出一个线性对数级别的解答
 * Ps.必须要不重复才行
 */
public class Question1_4_8_1 {

    public static int countEquals(int[] a) {
        int count = 0;
        // n²
        for (int i = 0; i < a.length; i++){
            for (int j = i + 1; j < a.length; j++){
                if (a[i] == a[j])
                    count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.print("输入随机生成的0~50之间的整数的数量：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] a = new int[num];
        sc.close();

        Random r = new Random();
        System.out.println("随机生成的元素为：");
        for (int i = 0; i < num; i++){
            a[i] = r.nextInt(51);
            System.out.print(a[i] + " ");
        }
        int fin = countEquals(a);
        System.out.print("\n相等的元素对的个数有：" + fin);
    }
}
