import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P102 1.3.10
 * Questiion:编写一个过滤器InfixToPostfix将算术表达式由中序表达式转为后序表达式
 */
public class InfixToPostfix {
    

    public static void main(String[] args) {
        System.out.print("输入一个算术表达式，中间用空格分隔，用ctrl + z + Enter结束输入：");
        Scanner sc = new Scanner(System.in);
        Stack<String> ops = new Stack<String>();
        Stack<Integer> vals = new Stack<Integer>();
        Stack<String> fin = new Stack<String>();
        String s;

        while (true){
            if (sc.hasNext()) s = sc.next();
            else break;
            if (s.equals("("));
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) ops.push(s);
            else if (s.equals(")")){
                if (vals.size() >= 2){
                    int val = vals.pop();
                    String temp = vals.pop() + " " + val + " " + ops.pop() + " ";
                    fin.push(temp);
                }else if (vals.size() == 1 && fin.size() > 1 || vals.isEmpty()){
                    String val = fin.pop();
                    String temp = fin.pop() + " " + val + " " + ops.pop() + " ";
                    fin.push(temp);
                }else if (vals.size() == 1 && fin.size() == 1){
                    String temp = vals.pop() + " " + fin.pop() + " " + ops.pop() + " ";
                    fin.push(temp);
                }
            }else vals.push(Integer.parseInt(s));
        }
        sc.close();
        while (ops.size() != 0){
            String op = ops.pop();
            if(vals.size() >= 2){
                int val = vals.pop();
                String temp =  vals.pop() + " " + val + " " + op + " ";
                fin.push(temp);
            }else{
                String val = fin.pop();
                String temp = fin.pop() + " " + val + " " + op + " ";
                fin.push(temp);
            }
        }
        System.out.print("该表达式的后序表达式是：" + fin.pop());
    }
}
