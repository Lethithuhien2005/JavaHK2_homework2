package Exercise_MultiThreadingOnReadMore;

import java.awt.TextArea;

public class LowThread extends Thread {
	private TextArea display;
	public LowThread(TextArea a) {
		display = a;
		setPriority(Thread.MIN_PRIORITY);
	}
	@Override
	public void run() {
		for (int y=1; y<=5; y++) {
			display.append("Low priority Thread!!!\n");
		}
	}
	
}
