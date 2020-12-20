import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Author: Sangs
 * Date:2020.12.20
 * Function: 全国高校计算机能力挑战赛区域赛决赛第四题
 * Question：某字符串描述了一个循环链表，但并非严格按照节点的顺序关系给出，两个节点的前后关系描述如下：
 * 			每个中括号中包含一个节点及其后继节点，节点名称由小写字母和数字组成，之间由"->"连接，
 * 			表示前驱后继关系，如[node1->node2][node3->node1][node2->node3]
 * 			表示链表节点的顺序为node1->node2->node3->node1
 * 			输入一个字符串，给定两个节点名称，输出前一节点到后一节点的距离长度
 * 输入说明：第一行为单循环链表的描述字符串(长度<=200)
 * 			第二行是两个节点的名称，节点A 节点B，以空格分开
 * 输出说明：节点A到节点B的距离(即A到B的长度而不是B到A的长度)
 * SampleIn：[node1->node2][node3->node1][node2->node3]
 * 			node1 node3
 * SampleOut:2
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String ss = scan.nextLine();
		String res1 = scan.next();
		String res2 = scan.next();
		int x = jx(res1);
		int y = jx(res2);
		int arr[][] = new int[200][2];
		for(int i = 0;i < 199;i ++) {
			arr[i][0] = -1;
			arr[i][1] = -1;
		}
		int cnt = 0;
		String[] spl = ss.split("\\]\\[");
		for(int i = 0;i < spl.length;i ++) {
 			String[] mid = spl[i].split("->");
 			arr[cnt][0] = jx(mid[0]);
 			arr[cnt][1] = jx(mid[1]);
 			cnt++;
		}
		int flag = 1;
		int a = x;
		int ans = 0;
		while(flag == 1) {
			for(int i = 0;i < cnt;i ++) {
				if(arr[i][0] == a) {
					if(arr[i][1] == y) {
						ans++;
						flag = 0;
						break;
					}else {
						a = arr[i][1];
						ans++;
						break;
					}
				}
			}
		}
        System.out.println(ans);
        scan.close();
	}
	
	private static int jx(String s) {
		int a = 0;
		String re = "[^0-9]";
		Pattern p = Pattern.compile(re);
		Matcher m = p.matcher(s);
		String ss = m.replaceAll("").trim();
		a = Integer.valueOf(ss);
		return a;
	}
}