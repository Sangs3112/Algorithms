import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Sangs
 * Date:2020.12.20
 * Function: 全国高校计算机能力挑战赛区域赛决赛第一题
 * Question：某高校食堂开办了一个自助餐厅，使用智能餐盘和自动结算，计算学生餐费
 * 			智能餐盘能够识别所打菜品类型，重量，单价(计价单位为：元/100克)
 * 			食堂计划以每道菜、汤独立定价；主食200克以内免费，200克以上部分收费
 * 			(如果打了多道主食，依据输入次序累计免费200克以下部分)
 * 			为鼓励学生健康饮食，学校鼓励学生联网分享运动信息，参照计步数进行阶梯折扣，0~5999步不打折
 * 			6000~9999步为9折，10000步以上均为8折。试根据餐盘提供的信息和学生的计步数，
 * 			计算该同学某次用餐的最终餐费
 * 输入说明：第一行为该生本次用餐所打的所有饭菜种类数量N(0<N<=10)
 * 			第二行起每一行顺序为盘中每道饭菜的信息，包括类型(M：荤菜/V：素菜/R:主食/S：汤)、
 * 			重量(克，整数)、单价(元/100克)
 * 			第N+2行为该同学的计步数
 * 输出说明：最终餐费(保留两位小数)
 * SampleIn：6
 * 			M 50 3.00
 * 			V 100 1.50
 * 			M 50 5.00
 * 			V 150 2.00
 * 			R 150 0.10
 * 			S 150 0.00
 * 			8754
 * SampleOut：7.65
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		List<food> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			food f = new food();
			String s[] = scan.nextLine().split(" ");
			f.kind=s[0];
			f.weight =Integer.parseInt(s[1]);
			f.price = Double.parseDouble(s[2]);
			list.add(f);
		}
		int work = Integer.parseInt(scan.nextLine());
		int rice = 200;
		double totalprice=0,K=0;
		scan.close();
		if(work<6000) { 
			K = 1;
		}else if(work<10000) { 
			K = 0.9;
		}else { 
			K = 0.8;
		}
		for(food i : list) {
			if(rice>=0&&i.kind.equals("R")) {
				if(rice<i.weight) {
					totalprice = totalprice+(i.weight-rice)*i.price;
				}else {
					rice = rice -i.weight;
				}
				continue;
			}
			totalprice = totalprice+i.weight*i.price;
		}
		System.out.println(totalprice*K/100.0);
	}
}

class food {
	public String kind;
	public int weight;
	public double price;
}