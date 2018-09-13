package com.huaxin.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

public class chat extends JFrame implements ActionListener{
	String nameOfFrame = "群聊";
	public static int port = 6666;
	public static String ip = "127.0.0.1";
	public TextArea tfTxt = new TextArea(); 
	  // 内容展示区域 
	public TextArea tarea = new TextArea();
	public static void main(String[] arg) {
		chat user = new chat();
		user.frame();
	}
	public void frame() {
		JPanel face = new JPanel();
		JPanel key = new JPanel();
		JButton jb1 = new JButton("发送");
		JButton jb2 = new JButton("取消");
		setName(nameOfFrame);
		setBounds(0, 0, 600, 600);
	//	setLocationRelativeTo(null);
		setResizable(false);
		tfTxt.setBounds(0, 0, 400, 400);
		tfTxt.setBackground(Color.WHITE);
		tfTxt.setEditable(false);
		tarea.setBounds(0,400,400,200);
		tarea.setBackground(Color.pink);
		face.setBounds(400,0 , 200, 400);
		face.setBackground(Color.GRAY);
		key.setBounds(400, 400, 200, 200);
		key.setLayout(null);
		jb1.setBounds(450, 450, 100, 20);
		jb2.setBounds(450, 520, 100, 20);
		key.add(jb1);
		key.add(jb2);
		add(tfTxt); 
	    add(tarea); 
	    add(face);
		add(key);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

		@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("发送")){
				tfTxt.append("You said:"+"\n"+tarea.getText()+"\n"+"\n");
				tarea.setText("");
				
	        }
			if(e.getActionCommand().equals("取消")){
	        	tarea.setText("");
	        }
		}
		
} 
