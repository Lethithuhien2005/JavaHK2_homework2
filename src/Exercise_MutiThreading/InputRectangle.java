package Exercise_MutiThreading;

import java.util.Scanner;

public class InputRectangle extends Thread {
	public int width, high;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	Scanner sc = new Scanner(System.in);
	@Override
	public synchronized void run() {
		System.out.println("Input the width of rectangle: ");
		setWidth(sc.nextInt());
		System.out.println("Input the high of rectangle: ");
		setHigh(sc.nextInt());
	}
}
