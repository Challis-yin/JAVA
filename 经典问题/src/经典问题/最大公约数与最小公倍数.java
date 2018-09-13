package 经典问题;
import java .util.*;
public class 最大公约数与最小公倍数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		while(a!=b) {
			if(a>b)
				while(a>b)
					a = a-b;
			if(a<b)
				while(a<b)
				b = b-a;
		}
			System.out.println(a);
	}

}
