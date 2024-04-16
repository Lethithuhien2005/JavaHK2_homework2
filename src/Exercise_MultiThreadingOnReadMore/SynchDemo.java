package Exercise_MultiThreadingOnReadMore;

public class SynchDemo {
	public static void main(String[] args) {
		Thread t1 = new MyThread(1);
		Thread t2 = new MyThread(2);
		t1.start();
		t2.start();
	}
}
