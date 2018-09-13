 package 图形界面练习;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
public class 尝试 {
	
	public static void main(String[] args) {
		System.setProperty( "Quaqua.tabLayoutPolicy","wrap");
		try{
		JFrame.setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}catch(Exception e){}

		denglu a = new denglu();
	}

}
class denglu{//
	public static database data = new database();
	UserFrame uf ;
	public denglu() {
		JFrame frame = new JFrame("MINI QQ");
		ImageIcon icon=new ImageIcon("f:/触不可及/QQ.jpg");  
		frame.setIconImage(icon.getImage());  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JPanel primary = new JPanel();
		primary.setLayout(new GridLayout(4,1));
		primary.setBackground(Color.GREEN);
		primary.setPreferredSize(new Dimension(355,200));
		
		//添加菜单
		JMenuBar bar = new JMenuBar();
		JMenu menu1 = new JMenu("帮助");
		JMenuItem item1 = new JMenuItem("注册");
		JMenuItem item2 = new JMenuItem("忘记密码");
		JMenu menu2 = new JMenu("登录状态");
		JMenuItem item3 = new JMenuItem("在线");
		JMenuItem item4 = new JMenuItem("隐身");
		JMenuItem item5 = new JMenuItem("忙碌");
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);
		bar.add(menu2);
		bar.add(menu1);
		frame.setJMenuBar(bar);
		
		
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/触不可及/timg.jpg");
		l.setIcon(i);
		//导入背景图片**
		
//		JCheckBox bc = new JCheckBox("记住密码");
//		frame.add(bc);
//		bc.setBounds(50,100,80,20);//此为建立一个可选的框
		
		JLabel lable = new JLabel("用户名");
		JLabel lable2 = new JLabel("密码");
		lable.setFont(new   java.awt.Font("Dialog",   0,   15)); 
		lable2.setFont(new   java.awt.Font("Dialog",   0,   15));  
		lable.setBounds(50,50,100,30);
		lable2.setBounds(50,70,100,30);
		l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
		
		
		//建立多个文字块
		JTextArea jta1 = new JTextArea("");
        jta1.setBounds(130, 58, 100, 20);
        JPasswordField jta2 = new JPasswordField("");
        jta2.setBounds(130, 78, 100, 20);
        
        
		JButton jb1 = new JButton("登录");
		JButton jb2 = new JButton("取消");
		//JButton jb3 = new JButton("注册");
		jb2.setContentAreaFilled(false);
		jb1.setContentAreaFilled(false);
		//jb3.setContentAreaFilled(false);
		jb1.setBounds(50,130, 80, 20);
		jb2.setBounds(160,130,80,20);
		//jb3.setBounds(50,100,80,20);
		//建立多个按钮
		
		//注册功能
		item1.addActionListener(new ActionListener(){
			String str;int name;String str2;

			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
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

				   JOptionPane.showMessageDialog(jb1,"您的输入密码前后不一致", "ERROR", 0);
					
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
			});

		item2.addActionListener(new ActionListener(){
			String str;int name;String str2;

			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
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

				   JOptionPane.showMessageDialog(jb1,"您的输入密码前后不一致", "ERROR", 0);
					
				}while(!str.equals(str2));
				
				try {
					data.tonew(name, str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		//登录功能
		jb1.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jta1.getText().trim());
				String code1 = new String(jta2.getPassword());
				try {
					if(data.trys(id, code1)) 
{
					frame.setVisible(false);
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

			});
		//为按钮1，添加了动作登录！！
		
		//取消功能
		jb2.addActionListener(new ActionListener(){
			//单击按钮执行的方法
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}

			});
		
		
		frame.add(lable);
		frame.add(lable2);
		frame.add(jb1);
		frame.add(jb2);
		frame.add(l);
		frame.add(jta1);
		frame.add(jta2);
		//frame.add(jb3);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
				
	}
}


