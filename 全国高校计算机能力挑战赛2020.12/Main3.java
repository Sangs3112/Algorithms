import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.20
 * Function: 全国高校计算机能力挑战赛区域赛决赛第三题
 * Questiion:给定一个含有N个整数的序列(2<N<10000)，输入一个整数K(K<N)，从K的位置把该序列分为2个部分
 *           分别为1到K和K+1到N。然后在1到K部分执行从小到大排序；在K+1到N部分执行从大到小排序
 *           然后再从K-2的位置把数据分为2个部分，继续执行上述操作，之后输出该整数序列
 * 输入说明：第一行是正整数N(2<N<10000)，正整数K(2<=K<N)
 *          第二行依次输入这N个数
 * 输出说明:经过操作后这N个数的序列。数字之间用空格隔开，所有数据输出后换行
 * SampleIn：10 5
 *           11 2 3 4 5 6 12 8 9 10
 * SampleOut：2 3 4 12 11 10 9 8 6 5 
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        sc.close();
        for(int i=0; i<=K-1; i++){
            for(int j=i+1; j<=K-1; j++){
                if(arr[i]>arr[j]){
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        for(int i=K; i <= N-1; i++){
            for (int j=i+1; j <= N-1; j++){
                if(arr[i] < arr[j]){
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        for (int i=K-2; i<=N-1; i++){
            for (int j=i+1; j <= N-1; j++){
                if(arr[i] < arr[j]){
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        for (int i = 0;i<N; i++)
            System.out.printf("%d ",arr[i]);
        System.out.println();
    }
}
