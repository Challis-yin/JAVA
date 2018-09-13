package TankWar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class tank0 extends Frame{
	
	tank hero = new tank(50,50,true,tank.Direction.STOP);
	
	Wall wall = new Wall(300,200);
	Wall wall1 = new Wall(500,200);

// static	tank enemy1 = new tank(90,90,false);
 static List<Explore> e = new LinkedList(); 
 static List <Missile> m = new LinkedList();
 static List<tank> enemys = new ArrayList();
	
	public void paint(Graphics g) {
		g.drawString("MISSILE COUNT: "+m.size(), 10, 50);
		g.drawString("YOU HAVE KILLED: "+e.size(), 10, 70);
		g.drawString("LIFE:  "+hero.getLife(),10,90);
		hero.draw(g); 
		wall.draw(g);
		wall1.draw(g);
		for(int i= 0;i<enemys.size();i++) {
			tank t = enemys.get(i);
			//t.hittank(enemys);
			t.hitwall(wall);
			t.hitwall(wall1);
			t.draw(g);
		}
//		enemy1.draw(g);
		for(int i = 0;i<m.size();i++) {
			Missile mis = m.get (i);
			mis.hitTank(enemys);
			mis.hitWall(wall);
			mis.hitWall(wall1);
			mis.hitTank(hero);
				mis.draw(g);
		}
		for(int i = 0;i<e.size();i++) {
			Explore exp = e.get(i);
			exp.draw(g);
		}
		}
		//y += 5;
	
	
	public void LanchFrame() {
//		JPanel primary = new JPanel();
//		primary.setBackground(Color.GREEN);
//		this.add(primary);
		this.setBackground(Color.green);
		this.setTitle("z̹�˴�ս");
		this.setLocation(0,0);	
		this.setSize(800,600);
		this.setResizable(false);
		
		this.addKeyListener(new KeyMonitor());
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
		});
		new Thread(new PaintThread()).start(); 
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] arg) {
		tank0 tank = new tank0();
		tank.LanchFrame();
	}
	
private class PaintThread implements Runnable{

		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	private class KeyMonitor extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			hero.KeyReyleased(e);
		}
		public void keyPressed(KeyEvent e) {
			hero.KeyPressed(e);
		}
	}
}











