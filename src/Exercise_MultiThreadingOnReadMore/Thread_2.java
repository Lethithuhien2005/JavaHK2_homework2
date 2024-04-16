package Exercise_MultiThreadingOnReadMore;

public class Thread_2 extends Thread {

	@Override
	public void run() {
		for (int i=2; i<=10; i+=2) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
}
