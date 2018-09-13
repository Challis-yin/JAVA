package 图形界面练习;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class 尝试2 {
	public static void main(String[] arg) {
		jiemian jiemian = new jiemian();
	}
}
class jiemian extends JFrame{
	int width = 430;int height = 210*2;
	 
	public jiemian(){
		
		setLayout(new GridLayout(2,1));
//		setLocationRelativeTo(null);   
		setSize(width, height);
		setTitle("MINI  QQ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel primary = new JPanel();
		//primary.setBackground(Color.white);
		primary.setSize(width,height/2);
		primary.setLayout(new GridLayout(5,1));
		
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/触不可及/afternoon.jpg");
		l.setIcon(i);
		add(l);
		//图片的添加！
		
		add(primary);
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("账号");
		JTextField jtf1 = new JTextField(20);
		jp1.add(jl1);
		jp1.add(jtf1);
		primary.add(jp1);
		//第一行！！
		
		//第二行！！
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("密码");
		JTextField jtf2 = new JTextField(20);
		jp2.add(jl2);
		jp2.add(jtf2);
		primary.add(jp2);
		
		//第三行！！
		JPanel jp3 = new JPanel();
		JButton jb1 = new JButton("注册");
		jp3.add(jb1);
		primary.add(jp3);
		
		JPanel jp4 = new JPanel();
		JButton jb2 = new JButton("登录");
		JButton jb3 = new JButton("取消");
		jp4.add(jb2);
		jp4.add(jb3);
		primary.add(jp4);
		
		
		
		
		setVisible(true);
	}
}
