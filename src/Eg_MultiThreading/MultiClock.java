package Eg_MultiThreading;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MultiClock extends JFrame implements ActionListener, Runnable {
	JButton createClock = new JButton("new Clock");
	JLabel clock = new JLabel();
	JLabel timeZone = new JLabel();
	Thread t;

	public MultiClock() {
		Container cont = this.getContentPane();
		// Lay thoi gian hien tai
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		clock = new JLabel(sdf.format(cal.getTime()), JLabel.CENTER);

		clock.setFont(new Font(clock.getFont().getName(), Font.PLAIN, 40));
		clock.setForeground(Color.RED);

		cont.add(createClock, "North");
		cont.add(clock);
		this.pack();
		this.setVisible(true);

		createClock.addActionListener(this);

		Thread t = new Thread(this);
		t.start();
	}

	public void tick() {
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			clock.setText(sdf.format(cal.getTime()));
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			tick();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(new MultiClock());
		t.start();
	}
	
	public static void main(String[] args) {
		new MultiClock();
	}
}
