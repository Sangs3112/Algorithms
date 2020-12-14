/**
 * Author: Sangs
 * Date:2020.12.6
 * Function:求两个数的最大公约数
 */
import java.util.Scanner;

public class greatestCommonDivisor{

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    
    public static void main(String[] args) {
        System.out.println("请输入两个数空格分隔，以便求得他们的最大公约数：");
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.print("他们的最大公约数是：");
        System.out.println(gcd(p, q));
        sc.close();
    }
}