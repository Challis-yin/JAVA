package TankWar;
import java.awt.*;

import TankWar.tank.Direction;
public class Missile {
	private int speed = 10;
	
	static final int height = 10,width = 10;
	
	tank.Direction dir;
	int x,y;
	
	private boolean live = true;
	
	public Missile(tank.Direction dir, int x, int y) {
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		if(this.hitTank(tank0.enemy1)||tank0.enemy1.getLive())
			if(!this.islive()) 
				tank0.m.remove(this);
			else {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, height, width);
		g.setColor(c);
		
		move();}
	}

	private void move() {
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
		}
		if(x<0||y<0||x>800||y>600) {
			live = false;
		}
		
	}
	
	public boolean islive() {
		return live;
			}
	public Rectangle getRec() {
		return new Rectangle(x,y,10,10);
	}
	
	public boolean hitTank(tank t) {
		if(this.getRec().intersects(t.getRec())) {
			if(t.getLive()) {
			t.setLive(false);
			this.live = false;
			Explore ee = new Explore(x, y);
			tank0.e.add(ee);
			return false;
		}}
		return true;
		
	}
}





