package TankWar;

import java.awt.Graphics;
import java.awt.Point;

import org.w3c.dom.events.MouseEvent;

public class yuan {
	int ca = 20;
	int x;
	int y;
	public void draw(Graphics g) {
		g.fillRect(x,y,ca,ca);
		g.fillOval(300, 300, ca, ca);
	}
	public void MousePress(MouseEvent e) {
		 x = e.getClientX();
		 y = e.getClientY();
	}
}
