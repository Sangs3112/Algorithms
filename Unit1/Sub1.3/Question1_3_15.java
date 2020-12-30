import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P103 1.3.15
 * Questiion:编写一个Queue的用例，接收一个命令行参数k并打印标准输入中的倒数第k个字符串
 *          假设标准输入中至少有k个字符串
 */
public class Question1_3_15 {


    public static void main(String[] args) {
        System.out.print("输入一个索引和大于这个索引的字符串个数，中间用空格分隔，输入ctrl + z + Enter结束输入：");
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new Queue<String>();
        int k = sc.nextInt();
        String s;
        while (true){
            if (sc.hasNext()) s = sc.next();
            else break;
            q.enqueue(s);
        }
        int index = q.size() - k + 1;
        for(String temp : q){
            index--;
            if(index == 0){
                System.out.println(temp);
                break;
            }
        }
        sc.close();
    }
}
