package Eg_MultiThreading;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class WorldTime extends Applet implements Runnable {
	private Date toDay = new Date();
	private Thread th = null;
	public void start() {
		if (th==null) {
			th = new Thread(this);
			th.start();
		}
	}
	@Override
	public void run() {
		while (true) {
			toDay = new Date();
			repaint();
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
	}
	public void paint(Graphics g) {
		g.drawString("Tel-Aviv: " + toDay, 50, 100);
		toDay.setTime(toDay.getTime()-7*3600*1000);
		g.drawString("New York: " + toDay, 50, 150);
		toDay.setTime(toDay.getTime()+7*3600*1000);
		g.drawString("Ha Noi: " + toDay, 50, 200);
	}
	public static void main(String[] args) {
		new WorldTime();
	}
}
