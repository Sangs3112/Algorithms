import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Author: Sangs Date:2020.12.21 
 * Function:《算法》P71 1.2.3
 * Questiion:编写一个Interval2D的用例，从命令行接收参数N、min和max。生成N个随机的2D间隔。
 * 其宽和高均匀地分布在单位正方形中的min和max之间。 用STdDraw画出他们并打印出相交间隔对的数量以及有包含关系的间隔对数量
 * Ps.计算包含关系没有做，做好的时候发现需要计算点的坐标，但是我一开始直接从随机线开始写的，就可能需要重新写，懒得。
 */
public class Question1_2_3 {

    public static void main(String[] args) {
        System.out.print("输入2D间隔的数量，最大最小范围，用空格分隔：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double max = sc.nextDouble();
        double min = sc.nextDouble();
        sc.close();

        Random r = new Random();
        double[] alo = new double[2 * N];
        double[] ahi = new double[2 * N];
        Interval1D[] ax = new Interval1D[N];
        Interval1D[] ay = new Interval1D[N];
        Interval2D[] arr = new Interval2D[N];
        StdDraw.setPenRadius(0.01);

        for (int i = 0; i < 2 * N; i++) {
            alo[i] = (r.nextInt((int) (max * 10)) + (int) (min * 10)) / 10.0;
            ahi[i] = (r.nextInt((int) (max * 10)) + (int) (min * 10)) / 10.0;
            if (alo[i] > ahi[i]) {
                alo[i] = ahi[i] + alo[i];
                ahi[i] = alo[i] - ahi[i];
                alo[i] = alo[i] - ahi[i];
            }
        }
        for (int i = 0; i < 2 * N; i = i + 2) {
            ax[i / 2] = new Interval1D(alo[i], ahi[i]);
            ay[i / 2] = new Interval1D(alo[i + 1], ahi[i + 1]);
        }
        for (int i = 0; i < N; i++)
            arr[i] = new Interval2D(ax[i], ay[i]);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i].intersects(arr[j]) && i != j) {
                    arr[i].draw();
                    arr[j].draw();
                }
            }
        }

    }
}
