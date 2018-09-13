package 图形界面练习;

import javax.swing.*;
import java.io.*;
import java.math.RoundingMode;
import java.net.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Liaotian extends JFrame implements ActionListener,ItemListener{
	private JTextArea jta1, tf;
	private JButton jb1/*fasong*/,jb2/**/,jb3,jb4;
	private String str1;
	 JComboBox<String> jcb ;
//	private Socket socket,client,fsocket;
//	private BufferedReader br,br1;
//	private BufferedWriter bw;
//	private PrintWriter pw;
//	private DataInputStream dis;  
//  private FileOutputStream fos; 
//	private FileInputStream fis; 
//	private DataOutputStream dos;
//	private String filepath;
public static void main(String[] arg){
	System.setProperty( "Quaqua.tabLayoutPolicy","wrap");
	try{
	JFrame.setDefaultLookAndFeelDecorated(true);
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	}catch(Exception e){}
	Liaotian a = new Liaotian("kkk");
}
public Liaotian(String name) {
			
		setTitle("A talk with "+name);
		JPanel key = new JPanel();
		setBounds(0, 0, 600, 600);
		setResizable(false);
		key.setBounds(400, 400, 200, 200);
		key.setLayout(null); 
	    
		jta1 = new JTextArea(380, 400);
		jta1.setLineWrap(true);
		jta1.setFont(new Font("宋体", Font.PLAIN, 20));
		jta1.setWrapStyleWord(true); 
	    jta1.setBackground(Color.pink);
		jta1.setEditable(false);
		JScrollPane text2=new JScrollPane(jta1);
		text2.setBounds(10,0,581,400);
		add(text2);
		
	    
		tf = new JTextArea();
		tf.setLineWrap(true);
		tf.setFont(new Font("宋体", Font.PLAIN, 20));
		tf.setWrapStyleWord(true); 
		tf.setBounds(10,420,370,170);
		tf.setBackground(Color.yellow);
		add(tf);
		
		/*
		 * 分隔条。。。。。。。。。。。。。。。。。
		 */
		JPanel jj1 = new JPanel(),jj2 = new JPanel(),jj3 = new JPanel();
		jj3.setBounds(0, 0, 5, 600);
		jj3.setBackground(Color.black);
		jj1.setBounds(0, 400, 600, 10);
		jj1.setBackground(Color.black);
		jj2.setBounds(380, 0, 10, 600);
		jj2.setBackground(Color.black);
		add(jj1);add(jj2);add(jj3);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("image/ni.jpg");
		
		 String[] sg= {"离线文件传输","在线文件传输"};
	    jcb = new JComboBox<String>(sg);
		jb1=new JButton("发   送");
		jb2=new JButton("文件传输");
		jb3=new JButton("表情");
		jb4 = new JButton(image);
		jb4.setBorderPainted(false);
		jb4.setContentAreaFilled(false); 
		jb4.setBounds(400,450,70,30);
		jb4.setBorder(BorderFactory.createRaisedBevelBorder()); 
		jb1.setBounds(400, 420, 100, 20);
		jb1.setBorder(BorderFactory.createRaisedBevelBorder()); 
		jb1.setFont(new  java.awt.Font("隶书",  1,  20));
//		jb1.setBackground(Color.green); 
		jb2.setBounds(400, 520, 100, 20);
		jb2.setBorder(BorderFactory.createRaisedBevelBorder());
		jcb.setBounds(400, 540, 120, 30);
		jcb.setBorder(BorderFactory.createRaisedBevelBorder());
		jb3.setBounds(400, 490, 100, 20);
		jb3.setBorder(BorderFactory.createRaisedBevelBorder());
		key.add(jb1);
		key.add(jcb);
		key.add(jb2);
		key.add(jb3);
		key.add(jb4);
		
		add(key);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		
		
		
		



		
		
		
		setVisible(true);
}
@Override
	public void actionPerformed(ActionEvent e) {
	
/**
 * 
 * 
 */
if(e.getActionCommand()=="发   送") {
		// TODO Auto-generated method stub
		str1=tf.getText();
		if(str1==null || str1.equals(""))  
            JOptionPane.showMessageDialog(null, "发送内容不能为空！");  
		   try {
			 
//			 bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			 pw=new PrintWriter(bw,true);
//			 pw.println(str1);
			 jta1.append("\n"+"你说："+str1+"\n");
			 tf.setText("");
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
if(e.getActionCommand()=="表情") {
		new NewFrame();
	}

if(e.getActionCommand()=="离线文件传输") {
	System.out.println("lixian now");
}

if(e.getActionCommand()=="在线文件传输") {
	System.out.println("zaixian now");
}


if(e.getSource()==jb4) {
	System.out.println("sfiawhiefheidhiovahwiohioefhihaiowehifheihf");
	main a = new main();
}



if(e.getActionCommand()=="文件传输") {
	
	/*
	 * *****************************
	 * 在线文件传输
	 */
	if(jcb.getSelectedIndex()==1) {
		System.out.println("wenjian chuangshu qidong");
		}
	/*
	 * *****************************************************
	 * 离线文件传输
	 */
	if(jcb.getSelectedIndex()==0) {
		System.out.println("wenjian chuangshu qidong");
	}
	
	// TODO Auto-generated method stub
//	JFileChooser jfc=new JFileChooser();  
//	File file;
//    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
//    jfc.showDialog(new JLabel(), "选择");  
//    file=jfc.getSelectedFile();  
//    if(file.isDirectory()){  
//        System.out.println("文件夹:"+file.getAbsolutePath()); 
//        filepath=file.getAbsolutePath();
//    }else if(file.isFile()){  
//        System.out.println("文件:"+file.getAbsolutePath());  
//        filepath=file.getAbsolutePath();
//    }  
//    System.out.println(jfc.getSelectedFile().getName());  
//    if(file.exists()) {
//    	try {
//    	fis = new FileInputStream(file);  
//        dos = new DataOutputStream(client.getOutputStream());  
//
//        // 文件名和长度  
//        dos.writeUTF(file.getName());  
//        dos.flush();  
//        dos.writeLong(file.length());  
//        dos.flush();  
//        
//        jta1.append("======== 开始传输文件 ========"+"\n");  
//        byte[] bytes = new byte[1024];  
//        int length = 0;  
//        long progress = 0;  
//        while((length = fis.read(bytes, 0, bytes.length)) != -1) {  
//            dos.write(bytes, 0, length);  
//            dos.flush();  
//            progress += length;  
////            jta1.append("| " + (100*progress/file.length()) + "% |");  
//        }   
//        jta1.append("======== 文件传输成功 ========"+"\n"); 
////        client.shutdownOutput();
//	}catch (Exception e) {  
//        e.printStackTrace();
//    }
//}
	
	

	}
}


@Override
public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}
}








		