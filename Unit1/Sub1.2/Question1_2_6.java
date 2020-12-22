import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2020.12.22
 * Function:《算法》P71 1.2.6
 * Questiion:如果字符串s中的字符循环移动任意位置之后能够得到另一个字符串t，那么s就被成为t的回环变位
 *          例如，ACTGACG和TGACGAC就是一个回环变位，反之亦然。
 *          判定这个条件在基因组序列中的研究中很重要。
 *          编写一个程序检查两个给定的字符串s和t是否互为回环变位。
 * Ps.答案只要一行用到indexOf()、length()和字符串连接的代码
 */
public class Question1_2_6 {

    public static boolean complex(String a, String b) {
        if(a.equals(b)) return true;
        if(a.length() != b.length()) return false;
        for(int i = 1; i <= a.length(); i++){
            String tempe = a.substring(i, a.length());
            String tempb = a.substring(0, i);
            String temp = tempe + tempb;
            if (temp.equals(b)) return true;
        }
        return false;
    }

    public static boolean simple(String a, String b){
        return a.length() == b.length() && (a+a).contains(b);
    }


    public static void main(String[] args) {
        System.out.println("输入两个字符串，回车分开：");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();
        if(complex(a, b))
            System.out.println("是回环序列");
        else
            System.out.println("不是回环序列");

        if(simple(a, b))
            System.out.println("是回环序列");
        else
            System.out.println("不是回环序列");
    }
}
