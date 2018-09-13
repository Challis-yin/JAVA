package 图形界面练习;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
public class UserFrame extends JFrame implements ActionListener,MouseListener{
		JPanel jpanel;
		JLabel[] lli = new JLabel[50];
		static int ci = 0;
//对第一个界面的panel
		JPanel jp1,jp2,jp3;
		JButton jb1,jb2,jb3;
		JScrollPane jsp;
		
//对第二个界面的Panel
		JButton jbq1,jbq2,jbq3;
		JPanel jpq1,jpq2,jpq3;
		JScrollPane jsp2;
		
//对第三个界面
		JButton jby1,jby2,jby3;
		JPanel jpy1,jpy2,jpy3;
		JScrollPane jsy3;
		
		database bd = new database();
		
		JMenuBar jmb1 ;
		JMenu jm1,jm2,jm3,jm4; 
		JMenuItem it1,it2,it3,it4,it5;
		
		CardLayout cl;
	public UserFrame() throws SQLException {
		setLocation(1000,0);
// 窗体大小
		setSize(250,700);
		
		jmb1 = new JMenuBar();
		jm1 = new JMenu("好友帮助");
		jm2 = new JMenu("群聊帮助");
		jmb1.add(jm1);jmb1.add(jm2);
		it1 = new JMenuItem("添加好友");
		it1.addActionListener(this);
		it2 = new JMenuItem("删除好友");
		it2.addActionListener(this);
		it3 = new JMenuItem("新建群聊");
		it3.addActionListener(this);
		it4 = new JMenuItem("添加群聊");
		it4.addActionListener(this);
		it5 = new JMenuItem("退出群聊");
		it5.addActionListener(this);
		jm1.add(it1);jm1.add(it2);
		jm2.add(it3);jm2.add(it4);jm2.add(it5);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb1 = new JButton("我的好友");
		jb1.addActionListener(this);
		jb2 = new JButton("我的群聊");
		jb2.addActionListener(this);
		jb3 = new JButton("休闲游戏");
		jb3.addActionListener(this);
		int kt = bd.getcount();	
		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new GridLayout(kt, 2, 2, 2));
		
		
		JLabel[] jlb = new JLabel[kt];
		String[] kkk = bd.getnickname();
		for(int i = 0;i<kt;i++) {
			jlb[i] = new JLabel(kkk[i],new ImageIcon("image/qq.jpg"), Label.RIGHT);
		//	jlb[i] = new JLabel(i+1+"",new ImageIcon("image/qq.jpg"), Label.RIGHT);
			jlb[i].addMouseListener(this);
			jp2.add(jlb[i]);
		}
		jsp = new JScrollPane(jp2);
		 
		
		jp3 = new JPanel(new GridLayout(1,2));
		jp3.add(jb1);jp3.add(jb2);
		jp1.add(jb3,"South");
		jp1.add(jsp,"Center");
		jp1.add(jp3,"North");
		
// *************************************************书写第二个窗口
		
		jbq1 = new JButton("我的好友");
		jbq1.addActionListener(this);
		jbq2 = new JButton("我的群聊");
		jbq2.addActionListener(this);
		jbq3 = new JButton("休闲游戏");
		jbq3.addActionListener(this);
		jpq1 = new JPanel(new BorderLayout());
		jpq2 = new JPanel(new GridLayout(20, 2, 2, 2));
		jpq3 = new JPanel(new GridLayout(1,2));
		jpq3.add(jbq1);
		jpq3.add(jbq2);
//		JLabel[] jlbq = new JLabel[20];
//		for(int i = 0;i<20;i++) {
//			jlbq[i] = new JLabel(i+1+"",new ImageIcon("image/qq.jpg"), Label.RIGHT);
//			jlbq[i].addMouseListener(this);
//			jpq2.add(jlbq[i]); 
//		}
		JLabel lll = new JLabel("公共聊天室",new ImageIcon("image/qq.jpg"), Label.RIGHT);
		lll.addMouseListener(this);
		jpq2.add(lll);
		jsp2 = new JScrollPane(jpq2);
		jpq1.add(jpq3,"North");
		jpq1.add(jsp2,"Center");
		jpq1.add(jbq3,"South");

// **************************************************第三个界面——游戏界面	
		jby1 = new JButton("我的好友");
		jby1.addActionListener(this);
		jby2 = new JButton("我的群聊");
		jby2.addActionListener(this);
		jby3 = new JButton("休闲游戏");
		jby3.addActionListener(this);
		jpy1 = new JPanel(new BorderLayout());
		jpy2 = new JPanel(new GridLayout(10, 1, 1, 1));
		jpy3 = new JPanel(new GridLayout(1,2));
		jpy3.add(jby1);
		jpy3.add(jby2);
		
		JLabel jl = new JLabel("Tank War",new 
				ImageIcon("image/kkk.jpg"),JLabel.LEFT);
		jl.addMouseListener(this);
		jpy2.add(jl);
		jsy3 = new JScrollPane(jpy2);
		
		jpy1.add(jpy3,"North");
//		jpy1.add(jby3,"Center");
		jpy1.add(jsy3,"South");
		
// *************************************************为frame设置布局管理器
		cl = new CardLayout();
//		jpanel = new JPanel();
		setLayout(cl);
		add(jp1,"1");
		add(jpq1, "2");
		add(jpy1, "3");
		setJMenuBar(jmb1);
		
		
		this.setTitle("用户界面");
		
		setResizable(false);
		
// ****************************************************显示窗体
		setVisible(true);
	}
	public static void main(String[] arg) throws SQLException {
		new UserFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String li = e.getActionCommand();
			if(li=="我的群聊") {
				cl.show(this.getContentPane(), "2");
			}
			if(li=="我的好友") {
				cl.show(this.getContentPane(), "1");
			}
			if(li=="休闲游戏") {
				cl.show(this.getContentPane(), "3");
			}
			if(li=="添加好友") {
				
			}
			if(li=="删除好友") {
				
			}
			if(li=="新建群聊") {
				String str;
				str = JOptionPane.showInputDialog(null, "请输入群号（要求数字）", 
						"群聊注册",JOptionPane.INFORMATION_MESSAGE);
				try {
					bd.addq(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} lli[ci] = new JLabel(str,new ImageIcon("image/qq.jpg"), Label.RIGHT);
				jpq2.add(lli[ci]);
				lli[ci].addMouseListener(this);
				ci++;
				cl.show(jpanel, "2");
			}
			if(li=="添加群聊") {
				String str;
				str = JOptionPane.showInputDialog(null, "请输入群号（要求数字）", 
						"添加群聊",JOptionPane.INFORMATION_MESSAGE);
				try {
					if(!bd.trys2(str)){
						 JOptionPane.showMessageDialog(jb1,"没有找到该群", "ERROR", 0);
					}
					else {
						lli[ci] = new JLabel(str,new ImageIcon("image/qq.jpg"), Label.RIGHT);
						jpq2.add(lli[ci]);
						lli[ci].addMouseListener(this);
						ci++;
						cl.show(jpanel, "2");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(li=="退出群聊") {
				String str;
				str = JOptionPane.showInputDialog(null, "请输入群号（要求数字）", 
						"退出群聊",JOptionPane.INFORMATION_MESSAGE);
				try {
					if(!bd.trys2(str)){
						 JOptionPane.showMessageDialog(jb1,"没有找到该群", "ERROR", 0);
					}
					else {
						int kkk = 0;
						for(int i = 0;i<ci;i++) {
							if(str.equals(lli[i].getName()))
								kkk = i;
						}
						jpq2.remove(lli[kkk]);
						cl.show(jpanel, "1");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
	
	/**
	 * *************************************鼠标监视，实现了对于不同用户的点击效果
	 */
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*
		 * *********************响应用户双击的事件
		 */
		if(arg0.getClickCount()==2) {
			/*
			 * *****************得到好友的编号
			 */
			String friendNo = ((JLabel)arg0.getSource()).getText();
			System.out.println(friendNo);
			if(friendNo.equals("Tank War")) {
				try {
					Process process = Runtime.getRuntime().exec("image/CCHESS.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Liaotian a = new Liaotian(friendNo);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)arg0.getSource();
		jl.setForeground(Color.ORANGE);
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)arg0.getSource();
		jl.setForeground(Color.BLACK);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
