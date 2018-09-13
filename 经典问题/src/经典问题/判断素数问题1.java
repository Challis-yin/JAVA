package 经典问题;
import java.util.*;
class yesorno{
	 
	
}
public class 判断素数问题1 
{public static boolean yes (int a) throws Exception  {
	Exception n = new Exception();
	if (a==2)
		return false;
	if (a==1) {
		System.out.println("1既不是素数也不是复数"+"\t"+"请重新输入：");
		throw n;
		}int count = 0;
	for (int i = 2;i<a;i++) 
		if(a%i==0)
			count++;
	if(count==0)
		return true;
	else 
		return false;
	}
	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		try{
			if(yes(n))System.out.println("是素数");
		}
		catch(Exception n1) {
			
		}
	}
}
