package ��������;
import java.util.*;
public class �������� {
	int num1 = 1;
	int num2 = 1;
	public static int mon(int n) {
		if(n == 1||n==2)
			return  1;
		return mon(n-1)+mon(n-2);
	}
	public static void main(String [] arg) {
		Scanner in = new Scanner(System.in);
	System.out.println("�������·�");
	int a = in.nextInt();
	int b = mon(a);
	System.out.println(b);
	}
class num{
	
}
}