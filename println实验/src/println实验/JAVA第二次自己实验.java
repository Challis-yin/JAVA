package printlnʵ��;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class JAVA�ڶ����Լ�ʵ�� {

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
//		JOptionPane.showMessageDialog(null,"�û��������������.", "�������", 0);
		InetAddress ia=InetAddress.getLocalHost(); //��ñ���IP��ַ���
		System.out.println("��������"+ ia.getHostName());  //�õ�������
		System.out.println(ia.getHostAddress()); //�õ�������ַ


	}

}
