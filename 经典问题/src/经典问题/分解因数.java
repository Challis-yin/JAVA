package 经典问题;
import java.util.*;
class num{
	int t;int under;
	public num(int n){
		t = n;
		under = 2;
	}
	public void mai() {
		if(t%under==0) {
			System.out.print("*"+under);
			t = t/under;
			if(t!=1)
				mai();
			if(t==1)
				return;
		}
		else {
			under++;
			mai();
		}
	}
}
public class 分解因数 {
	public static void main(String[] arg) {
	Scanner in = new Scanner(System.in);
	int n  =in.nextInt();
	num x = new num(n);
	System.out.print(n+" = 1");
	x.mai();
	}
}
