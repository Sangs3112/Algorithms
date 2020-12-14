/**
 * Author: Sangs
 * Date:2020.12.6
 * Function:牛顿迭代法开平方根
 */
import java.util.Scanner;

 public class extractARoot{

    public static double extract(double num) {
        if(num < 0) return Double.NaN;
        double err = 1e-15;//误差值
        double temp = num;
        while(Math.abs(temp-num/temp) > err*temp)//牛顿迭代法推导
            temp = (temp + num/temp)/2.0;//牛顿迭代法公式
        return temp;
    }


    public static void main(String[] args) {
        System.out.print("输入要开方的数：");
        Scanner sc = new Scanner(System.in);
        double k = sc.nextDouble();
        System.out.print("结果为：");
        System.out.println((extract(k)));
        sc.close();
    }
}