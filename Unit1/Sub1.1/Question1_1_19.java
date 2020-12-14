/**
 * Author: Sangs
 * Date:2020.12.8
 * Function:《算法》P34 1.1.19
 * Questiion:改写Fibonacci递归算法为更高效的算法
 * public static long F(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return F(N-1)+F(N-2);
    }
 */
public class Question1_1_19 {
    
    public static long FBetter(int N,long[] arr) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        arr[N % 2] = arr[0] + arr[1]; 
        return arr[N%2];
    }


    public static void main(String[] args) {

        long[] arr = new long[2];
        arr[0] = 0;
        arr[1] = 1;

        for(int N = 0;N<100;N++)
            System.out.println(N+" "+FBetter(N,arr));
    }
}
