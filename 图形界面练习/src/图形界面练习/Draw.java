package 图形界面练习;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

	public class Draw extends JFrame{

		public Draw() {
			new JFrame();
			setBounds(0, 0, 600, 400);
//			addMouseListener(new MouseMonitor());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		public static void main(String[] arg) {
			Draw a = new Draw();
			a.inis();
			
		}
		public void inis() {
			setTitle("画图");
			setLayout(new FlowLayout());
			listener li = new listener();
			String[] array = {
					"线","方","圆","笔","刷子","清空"
			};
			for(int i = 0;i<6;i++) {
				JButton jb = new JButton(array[i]);
				jb.addActionListener(li);
				add(jb);
			}
			setResizable(false);
			addMouseListener(li);
			addMouseMotionListener(li);
			setVisible(true);
			Graphics g = this.getGraphics();
			Color c = g.getColor();
			g.setColor(Color.black);
			li.setGraphics(g);
		}
		public class listener implements ActionListener,MouseListener,MouseMotionListener{
				public Graphics g;
				public int x1, y1;
				public int x2 , y2;
				public String commend = "线";
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void setGraphics(Graphics g) {
				// TODO Auto-generated method stub
				this.g= g;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				x1 = e.getX();
				y1 = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				x2 = e.getX();
				y2 = e.getY();
				if(commend.equals("线")) {
					g.drawLine(x1, y1, x2, y2);
				}
				if(commend.equals("方")) {
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}
				if(commend.equals("圆")) {
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}
			}

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				commend = e.getActionCommand();
				if(commend.equals("清空")) {
					repaint();
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if(commend.equals("笔")) {
					Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
					g2.setStroke(new BasicStroke(1.0f));
					x2 = e.getX();
					y2 = e.getY();
					g.drawLine(x1, y1, x2, y2);
					x1 = x2;
					y1 = y2;
				}
				if(commend.equals("刷子")) {
					Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
					g2.setStroke(new BasicStroke(3.0f));
					x2 = e.getX();
					y2 = e.getY();
					g.drawLine(x1, y1, x2, y2);
					x1 = x2;
					y1 = y2;
				}
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	