package Eg_MultiThreading;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class TrafficLight extends JApplet implements Runnable {
	String light = "green";
	public void init() {
		Thread one = new Thread(this);
		Thread two = new Thread(this);
		Thread three = new Thread(this);
		
		one.setName("red");
		two.setName("yellow");
		three.setName("green");
		
		one.start();
		two.start();
		three.start();
	}
	public void paint(Graphics g) {
		if (light.equals("green")) g.setColor(Color.GREEN);
		if (light.equals("yellow")) g.setColor(Color.YELLOW);
		if (light.equals("red")) g.setColor(Color.RED);
		g.fillOval(100, 100, 50, 50);
	}
	public void showLight() {
		light = Thread.currentThread().getName();
		repaint();
	}
	@Override
	public void run() {
		while (true) {
			showLight();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
