package ͼ�ν�����ϰ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class yonghu extends JFrame{
	//��������Ļ��λ��
	
	public void frame() {
	setLocation(1000,0);
	// �����С
	setSize(200,700);
	// ��ʾ����
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






