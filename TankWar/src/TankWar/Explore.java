package TankWar;

import java.awt.Color;
import java.awt.Graphics;

public class Explore {
	int x,y;
	int step = 0;
	private boolean live = true;
	
	int[] width = {4,7,10,16,30,40,37,19,9,2};
	
	public Explore(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		if(!live) return;
		if(step==width.length) return;
		
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, width[step], width[step]);
		step++;
		g.setColor(c);
	}
}
