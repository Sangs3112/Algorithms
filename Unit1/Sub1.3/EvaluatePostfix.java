import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P102 1.3.11
 * Questiion:编写一段程序EvaluatePostfix，从标准输入中得到一个后序表达式，求值并打印结果
 */
public class EvaluatePostfix {
    

    public static void main(String[] args) {
        System.out.print("输入一个后序表达式，中间用空格分隔，输入ctrl + z + Enter结束输入:");
        Scanner sc = new Scanner(System.in);
        Stack<Integer> vals = new Stack<Integer>();
        String s;
        while(true){
            if (sc.hasNext()) s = sc.next();
            else break;
            if (s.equals("+")){
                int temp = vals.pop();
                int fin = vals.pop() + temp;
                vals.push(fin);
            }else if(s.equals("-")) {
                int temp = vals.pop();
                int fin = vals.pop() - temp;
                vals.push(fin);
            }else if(s.equals("*")){
                int temp = vals.pop();
                int fin = vals.pop() * temp;
                vals.push(fin);
            }else if(s.equals("/")){
                int temp = vals.pop();
                int fin = vals.pop() / temp;
                vals.push(fin);
            }else vals.push(Integer.parseInt(s));
        }
        sc.close();
        System.out.println(vals.pop());
    }
}
