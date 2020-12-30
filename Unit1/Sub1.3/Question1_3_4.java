import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.30
 * Function:《算法》P102 1.3.4
 * Questiion:编写一个Stack的用例Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整
 *           例如，对于[()]{}{[()()]()}程序应该打印true
 *                对于[(])则打印false
 */
public class Question1_3_4 {

    public static boolean check() {
        Stack<String> st = new Stack<String>();
        System.out.print("输入一串括号，中间用空格分隔，输入完成后用ctrl + z + Enter结束输入：");
        Scanner sc = new Scanner(System.in);
        String s;
        while (true){
            if (sc.hasNext()) s = sc.next();
            else break;
            if(s.equals("(") || s.equals("[") || s.equals("{")) st.push(s);
            else if(s.equals(")")){
                String temp = st.pop();
                if(!temp.equals("(")){
                    sc.close();
                    return false;
                }
            }
            else if(s.equals("]")){
                String temp = st.pop();
                if(!temp.equals("[")) {
                    sc.close();
                    return false;
                }
            }
            else if(s.equals("}")){
                String temp = st.pop();
                if(!temp.equals("{")) {
                    sc.close();
                    return false;
                }
            }
        }
        sc.close();
        return true;
    }

    public static void main(String[] args) {
        if(check()) System.out.println("true");
        else System.out.println("false");
    }
}
