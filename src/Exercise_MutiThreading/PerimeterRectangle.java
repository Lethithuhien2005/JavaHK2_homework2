package Exercise_MutiThreading;

public class PerimeterRectangle extends Thread {
	private double width;
	private double high;
	
	public PerimeterRectangle(double width, double high) {
		this.width = width;
		this.high = high;
	}

	@Override
	public void run() {
		System.out.println("Perimeter : " + (width+high)*2);
	}
}
