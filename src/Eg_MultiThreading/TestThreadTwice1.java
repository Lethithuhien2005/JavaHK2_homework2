package Eg_MultiThreading;

public class TestThreadTwice1 extends Thread {

	@Override
	public void run() {
		System.out.println("thread is executing now.......");
	}
	public static void main(String[] args) {
		try {
			TestThreadTwice1 t1 = new TestThreadTwice1();
			t1.start();
			t1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
