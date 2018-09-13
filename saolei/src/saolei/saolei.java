package saolei;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.*;

public class saolei extends JFrame{
	
	int length = 600;int width = 600;
	
	public saolei() {
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, length);
		setLayout(new GridLayout(8,8));
		//JPanel primary = new JPanel();
		//primary.setLayout(new GridLayout(8,8));
		for(int i= 0;i<8*8;i++) {
			add(new Button(""+i));
		}
		//add(primary);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		saolei a = new saolei();
	}

}
