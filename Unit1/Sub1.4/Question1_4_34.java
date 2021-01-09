import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.9
 * Function:《算法》P134 1.4.34
 * Questiion:热还是冷。你的目标是猜出1到N之间的一个秘密的整数。
 *          每次猜完一个整数后，你会知道你猜测和这个秘密整数是否相等(若相等则游戏结束)
 *          不相等你会知道你的猜测相比上一次猜测距离该秘密整数是比较热(接近)
 *          还是比较冷(远离)
 */
public class Question1_4_34 {
    

    public static void main(String[] args) {
        System.out.print("输入随机数的最大值：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Random r = new Random();
        int num = r.nextInt(N)+1;
        while(true){
            System.out.print("输入你的猜测：");
            int fi = sc.nextInt();
            int dis = Math.abs(fi - num);
            if(dis == 0){
                System.out.println("猜测正确，随机数为：" + num);
                break;
            }else{
                System.out.print("再输一次：");
                int t = sc.nextInt();
                if(Math.abs(t - num) == 0){
                    System.out.println("猜测正确，随机数为：" + num);
                    break;
                }else if(dis < Math.abs(t - num)) System.out.println("冷了");
                else System.out.println("热了");
            }
        }
        sc.close();
    }
}
