package 经典问题;
import java.util.*;
public class 字符类型统计 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String kkk = in.nextLine();
		int num = 0;
		int letter = 0;
		int space = 0;
		int others = 0;
		char [] arr = kkk.toCharArray();
		for(int i = 0;i<arr.length;i++) {
			int a = arr[i];
			if(a>=48&&a<=57)
				num++;
			else if((a>=65&&a<=90)||(a>=97&&a<=122))
				letter++;
			else if(a==32)
				space++;
			else
				others++;
		}
	}

}
