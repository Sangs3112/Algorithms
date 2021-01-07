import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author: Sangs 
 * Date:2021.1.7 
 * Function:《算法》P132 1.4.8
 * Questiion:编写一个程序,计算输入中相等的整数对的数量。
 *          如果你的第一个程序是平方级别的，请继续思考并用Array.sort()给出一个线性对数级别的解答
 */
public class Question1_4_8_2 {

    public static int binarySearch(int[] a, int key){
        int l = 0;
        int r = a.length - 1;
        while(l <= r){
            int mid =( r - l ) / 2 + l;
            if(a[mid] < key) l = mid + 1;
            else if (a[mid] > key) r = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int countEqualsFast(int[] a){
        int count = 0;  
        for (int i = 0; i < a.length; i++){
            if(binarySearch(a, a[i]) > i) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.print("输入随机生成的0~50之间的整数的数量：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] a = new int[num];
        sc.close();

        Random r = new Random();
        System.out.println("随机生成的元素为：");
        for (int i = 0; i < num; i++){
            a[i] = r.nextInt(51);
            System.out.print(a[i] + " ");
        }
        Arrays.sort(a);// 先进行排序,方便后面二分查找和查询
        int fin = countEqualsFast(a);
        System.out.print("\n相等的元素对的个数有：" + fin);
    }
}
