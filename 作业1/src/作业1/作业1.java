//////////////////////////////////////////////////////////////////////////////////////////////
//计算平均值
//////////////////////////////////////////////////////////////////////////////////////////////
package 作业1;
import java.util.Scanner;
public class 作业1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
double A,B,C;
double G;
Scanner scan = new Scanner (System.in); 

System.out.print("A=");A = scan.nextInt();
System.out.print("B=");B = scan.nextInt();
System.out.print("C=");C = scan.nextInt();
G=(A+B+C)/3;
System.out.println("平均值="+G);
	}

}
