import java.util.Scanner;
/**
 * Author: Sangs
 * Date:2020.12.20
 * Function: 全国高校计算机能力挑战赛区域赛决赛第二题
 * Question：给定序列的前两项a1，a2，请产生符合下列要求的前10项整数序列：
 * 			若当前序列的最后两项的乘积为5位数以内的数，则把积作为后继项；否则后继项全为0
 * 输入说明：两个整数a1，a2
 * 输出说明：输出符合条件的前10项数字，数字之间用空格隔开，所有数据输出后换行
 * SampleIn：4 8
 * SampleOut：32 256 8192 0 0 0 0 0 0 0
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res[] = new int[12];
		res[0] = sc.nextInt();
        res[1] = sc.nextInt();
        sc.close();
		for(int i = 2;i < 12;i ++) {
			int temp = res[i-1]*res[i-2];
			if(temp<10000)	res[i] = temp;
			else	res[i] = 0;
		}
		for(int i = 2;i < 12;i ++) {
			System.out.print(res[i]+" ");
		}
		System.out.println();
	}
}