package Exercise_MultiThreadingOnReadMore;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PriorityDemo extends Frame {
	private HightThread high;
	private LowThread low;
	private TextArea output;
	
	public PriorityDemo() {
		super("PriorityDemo");
		output = new TextArea(10, 20);
		add(output);
		setSize(250, 200);
		setVisible(true);
		
		high = new HightThread(output);
		high.start();
		low = new LowThread(output);
		low.start();
	}
	public static void main(String[] args) {
		PriorityDemo app = new PriorityDemo();
		app.addWindowListener(new WindowAdapter() {
			public void windownClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
