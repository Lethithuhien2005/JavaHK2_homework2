package Eg_MultiThreading;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitDemo extends Applet implements Runnable, ActionListener {
	Thread t;
	int x=34, y=14;
	int dx=5, dy=5;
	Button start, stop;
	String status = "Go";
	public void init() {
		start = new Button("Start");
		stop = new Button("Stop");
		add(start);
		add(stop);
		start.addActionListener(this);
		stop.addActionListener(this);
		
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		while (true) {
			if (status.equals("Stop")) {
				synchronized (t) {
					try {
						t.wait();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			if (x+dx>this.getWidth() || x+dx<0) x =-dx;
			if (y+dy>this.getHeight() || y+dy<0) y=-dy;
			repaint();
			try {
				Thread.sleep(10);
			} catch(Exception e) {
			}
		}
	}
	public void paint(Graphics g) {
		g.fillOval(x, y, 40, 40);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==stop) {
			status = "Stop";
		}
		if (e.getSource()==start) {
			status = "Go";
			synchronized (t) {
				t.notify();
			}
		}
	}
}
