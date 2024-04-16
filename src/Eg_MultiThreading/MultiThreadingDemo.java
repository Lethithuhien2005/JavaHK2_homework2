package Eg_MultiThreading;

public class MultiThreadingDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("My thread is in running state");
	}

	public static void main(String args[]) {
		MultiThreadingDemo obj = new MultiThreadingDemo();
		Thread tobj = new Thread(obj);
		tobj.start();
	}
}
