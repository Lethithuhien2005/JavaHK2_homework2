package Eg_MultiThreading;

import java.awt.Graphics;
import java.awt.*;
import java.applet.*;

public class MovingBall extends Applet implements Runnable {
	Thread t;
	int x=34, y=14;
	int dx=5, dy=5;
	public void init()
	{
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while (true) {
			if (x+dx>this.getWidth() || x+dx<0) dx = -dx;
			if (y+dy>this.getHeight() || y+dy<0) dy = -dy;
			x=x+dx;
			y=y+dy;
			repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void paint(Graphics g) {
		g.fillOval(x, y, 40, 40);
	}
}
