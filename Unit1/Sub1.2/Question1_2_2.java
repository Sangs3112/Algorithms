import java.util.Scanner;

import edu.princeton.cs.algs4.Interval1D;

/**
 * Author: Sangs
 * Date:2020.12.21
 * Function:《算法》P71 1.2.2
 * Questiion:编写一个Interval1D的用例，从命令行接收一个整数N。
 *           从标准输入读取N个间隔(每个间隔由一对Double值定义)并打印出所有的相交间隔对
 */
public class Question1_2_2 {


    public static void main(String[] args) {
        System.out.print("输入间隔的个数：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] alo = new double[N];
        double[] ahi = new double[N];
        Interval1D[] line = new Interval1D[N];
        System.out.print("输入所有间隔的数据，用空格分开：");
        for (int i = 0; i < N; i++){
            alo[i] = sc.nextDouble();
            ahi[i] = sc.nextDouble();
            if(alo[i]>ahi[i]){
                alo[i] = ahi[i] + alo[i];
                ahi[i] = alo[i] - ahi[i];
                alo[i] = alo[i] - ahi[i];
            }
            line[i] = new Interval1D(alo[i], ahi[i]);
        }
        for(int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++){
                if(line[i].intersects(line[j])){
                    System.out.print(line[i]);
                    System.out.print(line[j]);
                }
            }
        }
        sc.close();
    }
}
