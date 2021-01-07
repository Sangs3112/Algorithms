import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.7
 * Function:《算法》P105 1.3.37
 * Questiion:N个深陷绝境的人一致同意通过以下方式减少生存人数
 *           他们做成一圈(位置记为0到N-1)并从第一个人开始报数,报到M的人会被杀死直到最后一个
 *           编写一个Queue用例Josephus,从命令行接收N和M并打印出人们被杀死的顺序
 *           最后一个数就是不会被杀死的人的位置
 */
public class Josephus {
    public static void main(String[] args) {
        System.out.print("输入人的个数和死亡的号数，空格分隔：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        Queue<Integer> q = new Queue<Integer>();
        QueueOfCircular<Integer> qoc = new QueueOfCircular<Integer>();
        for (int i = 0; i < N; i++)
            qoc.enqueue(i);
        
        int temp = 1;
        while(qoc.size() > 1){
            if(temp % M == 0){
                while (temp > N){
                    temp -= N;
                }
                q.enqueue(qoc.denum(temp));
                temp = 0;
            }
            temp++;
        }
        q.enqueue(qoc.dequeue());

        for (int item:q){
            System.out.print(item + " ");
        }
    }
}
