package ��������;
import java.util.*;
class yesorno{
	 
	
}
public class �ж���������1 
{public static boolean yes (int a) throws Exception  {
	Exception n = new Exception();
	if (a==2)
		return false;
	if (a==1) {
		System.out.println("1�Ȳ�������Ҳ���Ǹ���"+"\t"+"���������룺");
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
			if(yes(n))System.out.println("������");
		}
		catch(Exception n1) {
			
		}
	}
}
