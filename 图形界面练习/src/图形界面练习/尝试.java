 package ͼ�ν�����ϰ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
public class ���� {
	
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
		ImageIcon icon=new ImageIcon("f:/�����ɼ�/QQ.jpg");  
		frame.setIconImage(icon.getImage());  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		JPanel primary = new JPanel();
		primary.setLayout(new GridLayout(4,1));
		primary.setBackground(Color.GREEN);
		primary.setPreferredSize(new Dimension(355,200));
		
		//��Ӳ˵�
		JMenuBar bar = new JMenuBar();
		JMenu menu1 = new JMenu("����");
		JMenuItem item1 = new JMenuItem("ע��");
		JMenuItem item2 = new JMenuItem("��������");
		JMenu menu2 = new JMenu("��¼״̬");
		JMenuItem item3 = new JMenuItem("����");
		JMenuItem item4 = new JMenuItem("����");
		JMenuItem item5 = new JMenuItem("æµ");
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);
		bar.add(menu2);
		bar.add(menu1);
		frame.setJMenuBar(bar);
		
		
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/�����ɼ�/timg.jpg");
		l.setIcon(i);
		//���뱳��ͼƬ**
		
//		JCheckBox bc = new JCheckBox("��ס����");
//		frame.add(bc);
//		bc.setBounds(50,100,80,20);//��Ϊ����һ����ѡ�Ŀ�
		
		JLabel lable = new JLabel("�û���");
		JLabel lable2 = new JLabel("����");
		lable.setFont(new   java.awt.Font("Dialog",   0,   15)); 
		lable2.setFont(new   java.awt.Font("Dialog",   0,   15));  
		lable.setBounds(50,50,100,30);
		lable2.setBounds(50,70,100,30);
		l.setBounds(0, 0, i.getIconWidth(), i.getIconHeight());
		
		
		//����������ֿ�
		JTextArea jta1 = new JTextArea("");
        jta1.setBounds(130, 58, 100, 20);
        JPasswordField jta2 = new JPasswordField("");
        jta2.setBounds(130, 78, 100, 20);
        
        
		JButton jb1 = new JButton("��¼");
		JButton jb2 = new JButton("ȡ��");
		//JButton jb3 = new JButton("ע��");
		jb2.setContentAreaFilled(false);
		jb1.setContentAreaFilled(false);
		//jb3.setContentAreaFilled(false);
		jb1.setBounds(50,130, 80, 20);
		jb2.setBounds(160,130,80,20);
		//jb3.setBounds(50,100,80,20);
		//���������ť
		
		//ע�Ṧ��
		item1.addActionListener(new ActionListener(){
			String str;int name;String str2;

			//������ťִ�еķ���
			public void actionPerformed(ActionEvent e) {
				str = JOptionPane.showInputDialog(null, "�������û�����Ҫ�����֣�", 
						"�û���ע��",JOptionPane.INFORMATION_MESSAGE);
				try {
					name = Integer.parseInt(str);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "���������֣����˻ؽ�������ע��",
							"��ʾ",JOptionPane.ERROR_MESSAGE); 
					return;
				}
				do {
				str = JOptionPane.showInputDialog(null, "��������������", 
						"�û�ע��",JOptionPane.INFORMATION_MESSAGE);
				str2 = JOptionPane.showInputDialog(null, "���ٴ�������������", 
						"�û�ע��",JOptionPane.INFORMATION_MESSAGE);
				if(!str.equals(str2))

				   JOptionPane.showMessageDialog(jb1,"������������ǰ��һ��", "ERROR", 0);
					
				}while(!str.equals(str2));
				String str1 = JOptionPane.showInputDialog(null, "�������ǳ�(Ӣ�Ļ�������)", 
						"�û���ע��",JOptionPane.INFORMATION_MESSAGE);
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

			//������ťִ�еķ���
			public void actionPerformed(ActionEvent e) {
				str = JOptionPane.showInputDialog(null, "�������û�����Ҫ�����֣�", 
						"�����һ�",JOptionPane.INFORMATION_MESSAGE);
				try {
					name = Integer.parseInt(str);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "���������֣����Զ��˻ؽ���",
							"��ʾ",JOptionPane.ERROR_MESSAGE); 
					return;
				}
				do {
				str = JOptionPane.showInputDialog(null, "��������������", 
						"�����һ�",JOptionPane.INFORMATION_MESSAGE);
				str2 = JOptionPane.showInputDialog(null, "���ٴ�������������", 
						"�����һ�",JOptionPane.INFORMATION_MESSAGE);
				if(!str.equals(str2))

				   JOptionPane.showMessageDialog(jb1,"������������ǰ��һ��", "ERROR", 0);
					
				}while(!str.equals(str2));
				
				try {
					data.tonew(name, str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		//��¼����
		jb1.addActionListener(new ActionListener(){
			//������ťִ�еķ���
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
						JOptionPane.showMessageDialog(null,"�û��������������.", "�������", 0);
					    jta2.setText("");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			});
		//Ϊ��ť1������˶�����¼����
		
		//ȡ������
		jb2.addActionListener(new ActionListener(){
			//������ťִ�еķ���
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


