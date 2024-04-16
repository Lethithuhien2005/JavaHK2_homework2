package Exercise_MutiThreading;

public class AreaRectangle extends Thread {
	private double width;
	private double high;
	
	public AreaRectangle(double width, double high) {
		this.width = width;
		this.high = high;
	}
	@Override
	public void run() {
		System.out.println("Area= " + width*high);
	}	
}
