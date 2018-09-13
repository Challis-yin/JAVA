package 九宫格;
import java.util.*;
public class nine {
		public static void main(String [] arg) {
			Scanner in = new Scanner(System.in);
			System.out.print("输入一个奇数：");
			int kkk = in.nextInt();
			ninemain.jiugong(kkk);
		}
 }
 class ninemain{
	  static void jiugong(int n) {
		  int aa = n%2;
		  if(aa==0) {
			  System.out.println("程序错误，请输入奇数");
			  return;
		  }
		int[][] a = new int[n][n];
		int x = 0;int y = n/2;
		a[x][y] = 1;
		for (int i = 2;i<=n*n;i++) {
			x--;y--;
				x = (x+n)%n;
				y = (y+n)%n;
			if(a[x][y]!=0) {
				x=x+2;
				y++;
				x = x%n;
				y = y%n;
			}
			a[x][y] = i;
		}
		for(int i1 = 0;i1<n;i1++) {
			for(int s = 0;s<n;s++) {
				System.out.print(a[i1][s]+"\t");
			}
			System.out.println();
		}
	}
	
}

