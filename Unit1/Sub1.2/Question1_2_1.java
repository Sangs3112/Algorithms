import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Author: Sangs
 * Date:2020.12.21
 * Function:《算法》P71 1.2.1
 * Questiion:编写一个Point2D的用例，从命令行接收一个整数N。
 *           在单位正方形中生成N个随机点，然后计算两点之间的最近距离
 */
public class Question1_2_1{


    public static void main(String[] args) {
        System.out.print("输入随机点个数N：");
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        sc.close();
        double[] ax = new double[N];
        double[] ay = new double[N];
        Random r = new Random();
        StdDraw.setPenRadius(0.01);
        Point2D[] p = new Point2D[N];
        for (int i = 0; i < N; i++){
            ax[i] = r.nextDouble();
            ay[i] = r.nextDouble();
            p[i] = new Point2D(ax[i], ay[i]);
            p[i].draw();
        }
        int temp[] = new int[2];
        StdDraw.setPenRadius(0.001);
        for(int i = 0; i < N; i++){
            double min_dist = 2.0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(p[i].distanceTo(p[j])<min_dist){
                    min_dist=p[i].distanceTo(p[j]);
                    temp[0] = i;
                    temp[1] = j;
                }
            }
            StdDraw.line(ax[temp[0]], ay[temp[0]], ax[temp[1]], ay[temp[1]]);
            System.out.println(min_dist);
        }
    }
}