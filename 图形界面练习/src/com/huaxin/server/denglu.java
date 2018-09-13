package com.huaxin.server;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.*;

import 图形界面练习.UserFrame;
import 图形界面练习.database;


public class denglu extends JFrame implements ActionListener,MouseListener {
	private JPanel jp2,jp3;
	private JTextArea jta1;
	private JPasswordField jta2;
	private UserFrame uf ;
	public static database data = new database();
	public static void main(String[] arg) {
				zhuceframe aa = new zhuceframe();
				System.out.println("dsfads");
				denglu a = new denglu();
	}
	public denglu() {
		//第一个panel 显示我们的图标！！！！！！！！！！！！！
		
		
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("image/denglujpg.jpg");
		l.setIcon(i);
		l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
		

		jp2 = new JPanel();
		jp2.add(l);
		jp2.setBounds(0, 0, 500, 153);
		
		jp3 = new JPanel();
		jp3.setBounds(0,154,500,200);
		jp3.setLayout(null);
		JLabel l1 = new JLabel("用户名"); 
		l1.setFont(new Font("黑体", Font.PLAIN, 16));
		JLabel l2 = new JLabel("密码");
		l2.setFont(new Font("黑体", Font.PLAIN, 16));
		jta1 = new JTextArea("");
		jta2 = new JPasswordField("");
		JLabel l3 = new JLabel("注册");
		l3.setFont(new Font("黑体", Font.PLAIN, 16));
		JLabel l4 = new JLabel("忘记密码");
		l4.setFont(new Font("黑体", Font.PLAIN, 16));
		JButton jb1 = new JButton("登录");
		jb1.setFont(new Font("隶书", Font.PLAIN, 18));
		jb1.addActionListener(this);
		JButton jb2 = new JButton("取消");
		jb2.setFont(new Font("隶书", Font.PLAIN, 18));
		jb2.addActionListener(this);
		l3.addMouseListener(this);
		l4.addMouseListener(this);
		l1.setBounds(45,30,50,20);
		l2.setBounds(50,70,50,20);
		l3.setBounds(380,30,50,20);
		l4.setBounds(380,70,80,20);
		jb1.setBounds(100,110,80,30);
		jb2.setBounds(280,110,80,30);
		jta1.setBounds(100, 30, 250, 20);
		jta2.setBounds(100, 70, 250, 20);
		jp3.add(jta1);
		jp3.add(jta2);
		jp3.add(l3);
		jp3.add(l4);
		jp3.add(l1);
		jp3.add(l2);
		jp3.add(jb1);
		jp3.add(jb2);
		
		add(jp3);
		
		
		this.setTitle("********MiNi      QQ***********");
		this.setBounds(400,190,500, 153+200);
		add(jp2);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str=="登录") {
			int id = Integer.parseInt(jta1.getText().trim());
			String code1 = new String(jta2.getPassword());
			try {
				if(data.trys(id, code1)) 
{
				setVisible(false);
				try {
				uf = new UserFrame();}
				catch(Exception w) {
					
				}
}
				else {
					JOptionPane.showMessageDialog(null,"用户名或者密码错误.", "输入错误", 0);
				    jta2.setText("");
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(str=="取消") {
			jta1.setText("");
			jta2.setText("");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String f = ((JLabel)e.getSource()).getText();
		if(f=="注册") {
			String str;int name;String str2;
			str = JOptionPane.showInputDialog(null, "请输入用户名（要求数字）", 
					"用户名注册",JOptionPane.INFORMATION_MESSAGE);
			try {
				name = Integer.parseInt(str);
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入数字，请退回界面重新注册",
						"提示",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			do {
			str = JOptionPane.showInputDialog(null, "请输入您的密码", 
					"用户注册",JOptionPane.INFORMATION_MESSAGE);
			str2 = JOptionPane.showInputDialog(null, "请再次输入您的密码", 
					"用户注册",JOptionPane.INFORMATION_MESSAGE);
			if(!str.equals(str2))

			   JOptionPane.showMessageDialog(new JButton("O k"),"您的输入密码前后不一致", "ERROR", 0);
				
			}while(!str.equals(str2));
			String str1 = JOptionPane.showInputDialog(null, "请输入昵称(英文或者数字)", 
					"用户名注册",JOptionPane.INFORMATION_MESSAGE);
			try {
				data.add(name, str,str1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		if(f=="忘记密码") {
			String str;int name;String str2;
			str = JOptionPane.showInputDialog(null, "请输入用户名（要求数字）", 
					"密码找回",JOptionPane.INFORMATION_MESSAGE);
			try {
				name = Integer.parseInt(str);
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请输入数字，将自动退回界面",
						"提示",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			do {
			str = JOptionPane.showInputDialog(null, "请输入您的密码", 
					"密码找回",JOptionPane.INFORMATION_MESSAGE);
			str2 = JOptionPane.showInputDialog(null, "请再次输入您的密码", 
					"密码找回",JOptionPane.INFORMATION_MESSAGE);
			if(!str.equals(str2))

			   JOptionPane.showMessageDialog(new JButton("O  k"),"您的输入密码前后不一致", "ERROR", 0);
				
			}while(!str.equals(str2));
			
			try {
				data.tonew(name, str);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.gray);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.BLACK);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class zhuceframe{
	public  zhuceframe() {
		JFrame f1 = new JFrame("注册新用户");
		f1.setBounds(0,0,200,300);
		JPanel jpp = new JPanel();
		jpp.setLayout(new GridLayout(4, 2));
		jpp.setBounds(0,0,200,300);
		
		JLabel l1 = new JLabel("用户名");
		l1.setBounds(0,550,50,20);
		JLabel l2 = new JLabel("密码");
		l1.setBounds(30,90,50,20);
		JLabel l3 = new JLabel("确认密码");
		l1.setBounds(30,130,50,20);
		JTextArea jta1 = new JTextArea("");
		l1.setBounds(90,50,100,20);
		JTextArea jta2 = new JTextArea("");
		l1.setBounds(90,90,100,20);
		JTextArea jta3 = new JTextArea("");
		l1.setBounds(90,130,100,20);
		JButton jb1 = new JButton("确认");
		jb1.setBounds(30,180,80,30);
		jpp.add(l1);
		jpp.add(jta1);
		jpp.add(l2);
		jpp.add(jta2);
		jpp.add(l3);
		jpp.add(jta3);
		jpp.add(jb1);
		f1.add(jpp);
//		jb1.addActionListener(this);
		
		f1.setVisible(true);
	}
}





