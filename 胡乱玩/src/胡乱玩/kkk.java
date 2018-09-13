package 胡乱玩;
import java.util.*;
import javax.swing.JOptionPane; 
public class kkk {

	public static void main(String[] args) {
		 String str = null ;
		    int confirm=0;
		  	double count1,count2;
		  	while (confirm==0){
	str = JOptionPane.showInputDialog(null, "请输入被乘数", 
	"输入窗口1",JOptionPane.INFORMATION_MESSAGE);
		  	count1=Double.parseDouble(str);
		  	 str = JOptionPane.showInputDialog(null, "请输入乘数", 
		  			"输入窗口2",JOptionPane.INFORMATION_MESSAGE);
		  	 count2=Double.parseDouble(str);
		  	 JOptionPane.showMessageDialog(null, count1+"*"+count2+"="+count1*count2);
		  	 
		  	confirm=JOptionPane.showConfirmDialog(null, "还要继续乘法运算吗？","选择窗口",JOptionPane.YES_NO_OPTION);} 
		  	  
		  		  	JOptionPane.showMessageDialog(null, "谢谢使用");
		  	 
		  		  	System.exit(0);

	}
		  		  }