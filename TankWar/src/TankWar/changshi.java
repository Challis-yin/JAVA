package TankWar;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.w3c.dom.events.MouseEvent;



public class changshi extends Frame{
	int ca = 20;
	yuan a = new yuan();
	public void paint(Graphics g) {
		Color c = g.getColor();
		a.draw(g);
		g.drawLine(21, 12, 23, 43);
		g.setColor(c);
		g.setColor(c);
	}
	public changshi() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
	          a.MousePress( e);
			}
		});
		this.setBounds(0,0,800,600);
		this.setVisible(true);
		
		
	}
	public static void main(String[] arg) {
		changshi a = new changshi();
	}
}







