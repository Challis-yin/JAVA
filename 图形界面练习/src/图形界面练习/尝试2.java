package ͼ�ν�����ϰ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ����2 {
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
		ImageIcon i = new ImageIcon("f:/�����ɼ�/afternoon.jpg");
		l.setIcon(i);
		add(l);
		//ͼƬ����ӣ�
		
		add(primary);
		
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel("�˺�");
		JTextField jtf1 = new JTextField(20);
		jp1.add(jl1);
		jp1.add(jtf1);
		primary.add(jp1);
		//��һ�У���
		
		//�ڶ��У���
		JPanel jp2 = new JPanel();
		JLabel jl2 = new JLabel("����");
		JTextField jtf2 = new JTextField(20);
		jp2.add(jl2);
		jp2.add(jtf2);
		primary.add(jp2);
		
		//�����У���
		JPanel jp3 = new JPanel();
		JButton jb1 = new JButton("ע��");
		jp3.add(jb1);
		primary.add(jp3);
		
		JPanel jp4 = new JPanel();
		JButton jb2 = new JButton("��¼");
		JButton jb3 = new JButton("ȡ��");
		jp4.add(jb2);
		jp4.add(jb3);
		primary.add(jp4);
		
		
		
		
		setVisible(true);
	}
}
