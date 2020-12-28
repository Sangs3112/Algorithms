import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

/**
 * Author: Sangs
 * Date:2020.12.24
 * Function:Dijkstra双栈算数表达式求值算法
 */
public class Evaluate{
    

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();//符号栈
        Stack<Double> vals = new Stack<Double>();
        
        System.out.print("输入算数表达式每个字符中间用空格分开 ");
        System.out.print("输入完后请按ctrl + z + Enter 结束输入：");
        Scanner sc = new Scanner(System.in);
        String in;
        
        while(true){
            if(sc.hasNext()) in = sc.next();
            else break;
            if (in.equals("("));//如果是左括号就什么都不执行
            else if (in.equals("+") || in.equals("-")|| in.equals("*")| in.equals("/") || in.equals("sqrt"))
                ops.push(in);//如果是+ - * / 开方，就入符号栈
            else if (in.equals(")")){
                String op = ops.pop();
                double val = vals.pop();
                if (op.equals("+")) val = vals.pop() + val;
                else if (op.equals("-")) val = vals.pop() - val;
                else if (op.equals("*")) val = vals.pop() * val;
                else if (op.equals("/")) val = vals.pop() / val;
                else if (op.equals("sqrt")) val = Math.sqrt(val);
                vals.push(val);
            }
            else vals.push(Double.parseDouble(in));
            
        }

        while (ops.size() != 0){
            String op = ops.pop();
            double val = vals.pop();
            if (op.equals("+")) val = vals.pop() + val;
            else if (op.equals("-")) val = vals.pop() - val;
            else if (op.equals("*")) val = vals.pop() * val;
            else if (op.equals("/")) val = vals.pop() / val;
            else if (op.equals("sqrt")) val = Math.sqrt(val);
            vals.push(val);
        }
        sc.close();
        System.out.print("最终结果是：");
        System.out.print(vals.pop());   
    }
}