package Exercise_MutiThreading;

public class MainEx1 {
	public static void main(String[] args) {
	 InputRectangle t1 = new InputRectangle();
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double width = t1.getWidth();
		double high = t1.getHigh();
		
		Thread t2 = new PerimeterRectangle(width, high);
		Thread t3 = new AreaRectangle(width, high);
		t2.start();
		t3.start();
	}
}