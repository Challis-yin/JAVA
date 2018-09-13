package println实验;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class JAVA第二次自己实验 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
//final double kys = 88.8;
//char ttttt = 'A';
//int result=9;
//result =(14+8/2);
//
//
//
//System.out.println("kys"+kys+ttttt+result);
//		JOptionPane.showMessageDialog(null,"用户名或者密码错误.", "输入错误", 0);
		InetAddress ia=InetAddress.getLocalHost(); //获得本机IP地址情况
		System.out.println("主机名："+ ia.getHostName());  //得到主机名
		System.out.println(ia.getHostAddress()); //得到主机地址


	}

}
