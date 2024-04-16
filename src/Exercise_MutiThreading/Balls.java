package Exercise_MutiThreading;

import java.awt.Color;

public class Balls {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private Color color;
	public Balls(double x, double y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.dx = Math.random()*100;
		this.dy = Math.random()*100;
		this.color = color;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
