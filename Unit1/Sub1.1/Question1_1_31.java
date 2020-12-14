import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Author: Sangs
 * Date:2020.12.11
 * Function:《算法》P36 1.1.31
 * Questiion:随机连接，编写一段程序，从命令行接收一个整数N和double值p(0~1之间)作为参数
 *          在一个圆上画出大小为0.05且间距相等的N个点，然后将每对点按照概率p用灰线连接
 */
public class Question1_1_31 {

    public static void paint(int N, double p) {
        int r = 40;//半径固定为40
        double[] xarr = new double[N];
        double[] yarr = new double[N];//点的x和y坐标集
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);//设置横纵坐标范围不然默认是0~1
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(50, 50, r);

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(0.01);

        double ang = Math.toRadians(360/N);
        double start = .0;
        for (int i=0; i<N; i++){
            double x = 50 + r*Math.cos(start);
            double y = 50 + r*Math.sin(start);
            xarr[i] = x;
            yarr[i] = y;
            StdDraw.point(x, y);
            start += ang;
        }
        Random ran = new Random();
        for (int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if (ran.nextDouble()<=p)
                    StdDraw.line(xarr[i], yarr[i], xarr[j], yarr[j]);
            }
        }
    }
    

    public static void main(String[] args) {
        System.out.print("输入点的个数N和概率p(0<p<1),空格分隔：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double p = sc.nextDouble();
        sc.close();
        paint(N, p);
    }
}
