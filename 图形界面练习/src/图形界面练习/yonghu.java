package 图形界面练习;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class yonghu extends JFrame{
	//设置在屏幕的位置
	
	public void frame() {
	setLocation(1000,0);
	// 窗体大小
	setSize(200,700);
	// 显示窗体
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addp() {
		JPanel primary = new JPanel();
		CardLayout card = new CardLayout();
		primary.setLayout(card);
		
		add(primary);
	}
}






