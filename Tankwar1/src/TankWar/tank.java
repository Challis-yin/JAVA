package TankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java .util.*;

public class tank {
	int x;int y;
	int oldx,oldy;
	
	blood bb = new blood();
	
	 public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	boolean good;
	boolean live = true;
	
	int life = 101;
	
	static final int height = 30,width = 30;
	
	static Random r = new Random();
	
	final int speed = 5;
	int step = r.nextInt(12)+3;
	
	private boolean bL = false,bU = false,bR = false,bD = false;
	static enum Direction{L,LU,R,RU,U,LD,D,RD,STOP};
	
	 Direction dir = Direction.STOP; 
	 Direction ptdir = Direction.D;
	
	public tank(int x,int y,boolean good,Direction dir) {
		oldx = x;
		oldy = y;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.good = good;
	}
	
	void move() {
		oldx = x;
		oldy = y;
		switch(dir) {
		case L:
			x-=speed;
			break;
		case LU:
			x-=speed;
			y-=speed;
			break;
		case R:
			x+=speed;
			break;
		case RU:
			x+=speed;
			y-=speed;
			break;
		case U:
			y-=speed;
			break;
		case LD:
			x-=speed;
			y+=speed;
			break;
		case D:
			y+=speed;
			break;
		case RD:
			x+=speed;
			y+=speed;
			break;
		case STOP:
			break;
		}
		if(dir!= Direction.STOP)
			ptdir = dir;
		if(x<0) x=0;
		if(y<0) y=0;
		if(x>800) x=800;
		if(y>600) y=600;
		if(!good) {
			if(step==0) {
			Direction[] dirs = Direction.values();
			int rn = r.nextInt(dirs.length);
			dir = dirs[rn];
			step = r.nextInt(12)+3; 
			}
			step--;
			if(r.nextInt(40)>37)
			tank0.m.add(fire());
		}
	}
	
	public void draw(Graphics g) {
		if(!live)
			return;
		Color c = g.getColor() ;
		if(good) {
			bb.draw(g);
			g.setColor(Color.RED);}
		else
			g.setColor(Color.gray);
		g.fillOval(x,y, height, width);
		g.setColor(c);
		
		switch(ptdir) {
		case L:
			g.drawLine(x+width/2, y+height/2, x, y+height/2);
			break;
		case LU:
			g.drawLine(x+width/2, y+height/2, x, y);
			break;
		case R:
			g.drawLine(x+width/2, y+height/2, x+width, y+height/2);
			break;
		case RU:
			g.drawLine(x+width/2, y+height/2, x+width, y);
			break;
		case U:
			g.drawLine(x+width/2, y+height/2, x+width/2, y);
			break;
		case LD:
			g.drawLine(x+width/2, y+height/2, x, y+height);
			break;
		case D:
			g.drawLine(x+width/2, y+height/2, x+width/2, y+height);
			break;
		case RD:
			g.drawLine(x+width/2, y+height/2, x+width, y+height);
			break;
				}
		
		move(); 
	}
 	public void KeyPressed(KeyEvent e) {
 		if(!good)
 			return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		}
		LocationDirection();
	}
	void LocationDirection() {
		if(bL&&!bR&&!bU&&!bD) dir = Direction.L;
		else if(bL&&!bR&&bU&&!bD) dir = Direction.LU;
		else if(!bL&&bR&&!bU&&!bD) dir = Direction.R;
		else if(!bL&&bR&&bU&&!bD) dir = Direction.RU;
		else if(!bL&&!bR&&bU&&!bD) dir = Direction.U;
		else if(bL&&!bR&&!bU&&bD) dir = Direction.LD;
		else if(!bL&&!bR&&!bU&&bD) dir = Direction.D;
		else if(!bL&&bR&&!bU&&bD) dir = Direction.RD;
		else if(!bL&&!bR&&!bU&&!bD) dir = Direction.STOP;
		
				
	}

	public void KeyReyleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			superfire();
			break;
		case KeyEvent.VK_W:
			if(good)
				live = true;
				life = 101;
			break;
		case KeyEvent.VK_ENTER:
			tank0.enemys.clear();
			break;
		case KeyEvent.VK_Q:
			for(int i = 0;i<5;i++) {
			tank0.enemys.add(new tank(20,20+i*100,false,Direction.D));
			}
			for(int i = 0;i<5;i++) {
				tank0.enemys.add(new tank(780,20+i*100,false,Direction.D));
				}
			break;
		case KeyEvent.VK_SPACE :
			if(live)
			tank0.m.add(fire());
			break;
		case KeyEvent.VK_RIGHT: 
			bR = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		}
		LocationDirection();
	}
	
	public Missile fire() {
		Missile x = new Missile(ptdir,this.x+width/2-Missile.width/2
				,y+height/2-Missile.height/2,good);
		return x;
	}

	public boolean getLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Rectangle getRec() {
		return new Rectangle(x,y,50,50);
	}
	public void hitwall(Wall a) {
		if(this.getRec().intersects(a.getRec())) {
			x = oldx;
			y = oldy;
			}
	}
	public void hittank(List<tank> tanks) {
		for(int i = 0;i<tanks.size();i++) {
			tank a = tanks.get(i);
			if(this!=a)
			if(this.getRec().intersects(a.getRec())) {
				x = oldx;
				y = oldy;
				}
		}
	}
	public Missile fire(Direction dir) {
		Missile x = new Missile(dir,this.x+width/2-Missile.width/2
				,y+height/2-Missile.height/2,good);
		return x;
	}
	public void superfire() {
		Direction[] dir = Direction.values(); 
		for(int i = 0;i<8;i++) {
			tank0.m.add(fire(dir[i]));
		}
	}
	class blood{
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.red);
			g.drawRect(x, y-10, width, 10);
			int xx = width*life/101;
			g.fillRect(x, y-10, xx, 10);
			g.setColor(c);
		}
	}
}















