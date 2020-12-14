import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.10
 * Function:《算法》P35 1.1.30
 * Questiion:创建一个N*N的布尔数组a[][]。其中当i和j互质时(没有相同因子)，a[i][j]为true，否则为false
 * 分解质因数法和辗转相除法
 */
public class Question1_1_30 {

    public static int prime(int i, int j) {
        if(i<j) {i=i+j; j=i-j; i=i-j;}//交换，使得大数在前，小数在后
        while(i%j != 0){
            int temp = j;
            j = i%j;
            i = temp;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.print("输入数组阶数：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        boolean[][] a = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(i==0 || j==0) continue;
                int fin = prime(i, j);
                if(fin == 1) a[i][j] = true;
            }
        }

        System.out.println("按照要求生成的布尔二维数组为：");
        for(int i=0; i<N; i++){
            System.out.print("[");
            for (int j=0; j<N; j++)
                System.out.printf(" %b ",a[i][j]);
            System.out.println("]");
        }
    }
}
