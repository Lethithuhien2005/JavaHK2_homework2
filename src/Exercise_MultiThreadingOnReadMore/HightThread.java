package Exercise_MultiThreadingOnReadMore;

import java.awt.TextArea;

public class HightThread extends Thread {
	private TextArea display;
	public HightThread(TextArea a) {
		display = a;
		setPriority(Thread.MAX_PRIORITY);
	}
	@Override
	public void run() {
		for (int x=1; x<=5; x++) {
			display.append("High priority Thread!!!\n");
		}
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
