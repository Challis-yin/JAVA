package ������;
import java.util.*;
import javax.swing.JOptionPane; 
public class kkk {

	public static void main(String[] args) {
		 String str = null ;
		    int confirm=0;
		  	double count1,count2;
		  	while (confirm==0){
	str = JOptionPane.showInputDialog(null, "�����뱻����", 
	"���봰��1",JOptionPane.INFORMATION_MESSAGE);
		  	count1=Double.parseDouble(str);
		  	 str = JOptionPane.showInputDialog(null, "���������", 
		  			"���봰��2",JOptionPane.INFORMATION_MESSAGE);
		  	 count2=Double.parseDouble(str);
		  	 JOptionPane.showMessageDialog(null, count1+"*"+count2+"="+count1*count2);
		  	 
		  	confirm=JOptionPane.showConfirmDialog(null, "��Ҫ�����˷�������","ѡ�񴰿�",JOptionPane.YES_NO_OPTION);} 
		  	  
		  		  	JOptionPane.showMessageDialog(null, "ллʹ��");
		  	 
		  		  	System.exit(0);

	}
		  		  }