package Eg_MultiThreading;

public class DaemonThread extends Thread {
	public DaemonThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Check if its DaemonThread: " + Thread.currentThread().isDaemon());
	}
	
	public static void main(String[] args) {
		DaemonThread t1 = new DaemonThread("t1");
		DaemonThread t2 = new DaemonThread("t2");
		t1.setDaemon(true);
		t1.start();
		t2.start();
	}
}
