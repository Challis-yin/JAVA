package ��ҵ1;
import java.util.*;
public class ��һ�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int cc = 1;
		int count = 0;
		for(;a != 0;) {
			if(a == 1) {
				count++;
				cc = 1;
			}
			if(a ==2) {
				count = count +2*cc;
				cc++;
			}
			a = in.nextInt();
		}
		System.out.println(count);
	}

}
