import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.9
 * Function:《算法》P133 1.4.22
 * Questiion:仅用加减法实现二分查找。编写一个程序，给定一个含有N个不同的int值的按照升序排列的数组
 *          判断它是否含有给定的整数，只能使用加法和减法以及常熟的额外内存空间。
 *          程序的运行时间咋最坏情况下应该和logN成正比
 * Ps.用斐波那契数列代替2的幂进行查找，用两个变量保存Fk课Fk-1并在[i, i+Fk]之间查找
 *    在每一步中，使用减法计算Fk-2，检查i+Fk-2处的元素
 *    并根据结果将搜索范围变为[i, i+Fk]或[i+Fk-2,i+Fk-2+Fk-1]
 */
public class Question1_4_22 {
    
    public static int mihaiPatrascu(int[] a, int key) {
        Arrays.sort(a);
        // 通过斐波那契序列将列表索引转换成两半Fl & Fr
        // 其中Fr - Fl - 1 = (a.length/2)
        int Fl = 1;
        int Fr = 1;
        while(Fr <= a.length){
            int temp = Fr;
            Fr += Fl;
            Fl = temp;
        }

        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + Fr - Fl - 1;
            if(a[mid] < key){
                lo = mid + 1;
                // 需要对mid进行更新，也就是对Fr和Fl进行更新
                int temp = Fl;
                Fl = Fr - Fl;
                Fr = temp; 
            }
            else if (a[mid] > key){
                hi = mid - 1;
                int temp = Fl;
                Fl = Fr - Fl;
                Fr = temp;
            }
            else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.print("输入整数数组的大小和其相应的值：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        System.out.print("输入要查找的值：");
        int key = sc.nextInt();
        sc.close();

        int fin = mihaiPatrascu(a, key);
        if(fin == -1) System.out.println("没有找到");
        else System.out.println("索引为：" + fin);
    }
}
