package 作业2;
import java.util.Scanner;
public class 作业2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	double 时,分,秒;
	double 总秒;
	Scanner scan = new Scanner (System.in); 
	System.out.println("时=");
	System.out.println("分=");
	System.out.println("秒=");
	时 = scan.nextInt();
	分 = scan.nextInt();
	秒 = scan.nextInt();
	总秒=时*3600+分*60+秒;
System.out.println(时+"小时"+分+"分"+秒+"秒"+"等于"+总秒+"秒");
}
}