import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.8 
 * Function:《算法》P133 1.4.19
 * Questiion:矩阵的局部最小值。给定一个含有N²个不同整数的N*N数组a[] 
 *          设计一个运行时间和N成正比的算法来找出一个局部最小元素
 *          满足a[i][j]<a[i+1][j] a[i][j]<a[i][j+1] a[i][j]<a[i-1][j] a[i][j]<a[i][j-1]
 *          程序的运行时间在最坏情况下应该和N成正比
 */
public class Question1_4_19 {
    
    public static int localMinOfMatrix(int[][] a){
        int N = (int)Math.sqrt(a.length);
        int lo = 0;
        int hi = N - 1;
        while(lo <= hi){
            int mid = (hi - lo)/2 + lo;
            if(mid > 0 && mid < N - 1){
                if(a[mid][mid] < a[mid - 1][mid] && a[mid][mid] < a[mid][mid - 1]
                && a[mid][mid] < a[mid + 1][mid] && a[mid][mid] < a[mid][mid + 1]) return a[mid][mid];
                else{
                    if(a[mid][mid - 1] < a[mid][mid + 1]) hi = mid - 1;
                    else lo = mid + 1;
                }
            }else if (mid == 0){
                if(a[mid][mid] < a[mid][mid + 1] && a[mid][mid] < a[mid + 1][mid]) return mid;
                else break;
            }else if(mid == N - 1){
                if(a[mid][mid] < a[mid - 1][mid] && a[mid][mid] < a[mid][mid - 1]) return mid;
                else break;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.print("输入随机整数矩阵的阶数：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int[][] a = new int[N][N];
        Random r = new Random();
        System.out.println("随机整数矩阵为：");
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                a[i][j] = r.nextInt(N*N);
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        int fin = localMinOfMatrix(a);
        if(fin == -1) System.out.println("没有局部最小值");
        else System.out.println("局部最小值为：" + fin);
    }
}
