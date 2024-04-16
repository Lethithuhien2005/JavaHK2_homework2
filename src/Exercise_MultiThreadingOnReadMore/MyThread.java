package Exercise_MultiThreadingOnReadMore;

public class MyThread extends Thread {
	int start;
	public MyThread(int s) {
		start = s;
	}
	public static synchronized void go(int s) {
		for (int i=s; i<=10; i+=2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
	@Override
	public void run() {
		go(start);
	}
	
}
