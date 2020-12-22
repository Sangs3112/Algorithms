import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.22
 * Function:《算法》P71 1.2.11
 * Questiion:根据Date的API实现一个SmartDate类型，在日期非法时抛出一个异常
 */
public class Question1_2_11 {


    public static void main(String[] args) {
        System.out.print("输入年月日，中间用空格分开：");
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        sc.close();
        System.out.println("输入的日期是"+new SmartDate(y, m, d));
    }
}
