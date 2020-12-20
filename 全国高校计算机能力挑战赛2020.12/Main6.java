import java.util.Scanner;
/**
 * Author: Sangs
 * Date:2020.12.20
 * Function: 全国高校计算机能力挑战赛区域赛决赛第六题
 * Question：仓库中有m袋大米，它们的重量互不相同，分别为N1，N2，......，Nm千克，
 *          东方学校食堂需要大米N千克，需要从仓库中挑选若干袋大米，重量之和恰好为N千克
 *          请统计一共有多少种组合方法，使得重量符合要求
 * 输入说明：第一行输入两个正整数，分别为m(m<=60，为大米袋数)和N(N<=1000，为需要大米重量)
 *          第二行输入m个正整数，表示m袋大米重量(已知每袋大米重量不超过200千克)
 * 输出说明：选择若干袋大米，重量恰好为N的不同组合方法总数
 * SampleIn：5 20
 *          3 4 11 2 9
 * SampleOut：2
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[m];
        for (int i=0; i<m; i++)
            arr[i] = sc.nextInt();
        sc.close();
        int temp=0;

        for (int i=1;i<1<<m; i++){
            int sum = 0;
            
            for(int j = 0;j<m;j++){
                if((i & 1<<j)!=0)
                    sum += arr[j];
            }
            if(sum == N)
                temp++;
        }
        System.out.println(temp);
    }   
}
