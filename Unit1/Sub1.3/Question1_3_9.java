import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P102 1.3.9
 * Questiion:编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式
 * SampleIn：1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * SampleOut:( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Question1_3_9 {


    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Integer> vals = new Stack<Integer>();
        Stack<String> fin = new Stack<String>();
        String s;

        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个没有左括号的表达式，中间用空格分隔，输入完成后用ctrl + z + Enter结束：");
        while (true){
            if(sc.hasNext()) s = sc.next();
            else break;
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) ops.push(s);
            else if (s.equals(")")){
                String op = ops.pop();
                if(vals.size() >= 2){
                    int val = vals.pop();
                    String temp = "( " + vals.pop() + " " + op + " " + val + " )";
                    fin.push(temp);
                }else if (vals.size() == 1 && fin.size() > 1 || vals.isEmpty()){
                    String val = fin.pop();
                    String temp = "( " + fin.pop() + " " + op + " " + val + " )";
                    fin.push(temp);
                }
                else if (fin.size() == 1 && vals.size() == 1){
                    String temp = "( " + vals.pop() + " " + op + " " + fin.pop() + " )";
                    fin.push(temp);
                }
            }else vals.push(Integer.parseInt(s));
        }
        sc.close();
        System.out.println(fin.pop());
    }
}
