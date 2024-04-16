package Eg_MultiThreading;

class MyThread extends Thread {

}
class DontOverrideRun{
	public static void main(String[] args) {
		System.out.println("Started Main.");
		MyThread thread1 = new MyThread();
		thread1.start();
		System.out.println("Ended Main.");
	}
}