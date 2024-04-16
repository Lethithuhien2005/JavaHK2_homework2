package Exercise_MutiThreading;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.*;

public class Ex4 extends JFrame implements Runnable {
	private JButton jButton_newClock;
	private JLabel jLabel_timeZone;
	private JTextField jTextField_timeZone;
	private JLabel jLabel_clock;

	public Ex4() {
		this.setTitle("Time Zone");
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f = new Font("Arial", Font.BOLD, 15);

		jLabel_clock = new JLabel("Please input the time zone");
		jLabel_clock.setFont(f);
		jLabel_clock.setForeground(Color.red);

		jButton_newClock = new JButton("New clock");
		jButton_newClock.setFont(f);
		jButton_newClock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("New clock")) {
					Thread t = new Thread(new Ex4());
					t.start();
				}
			}
		});

		jLabel_timeZone = new JLabel("Time zone");
		jLabel_timeZone.setFont(f);
		jTextField_timeZone = new JTextField();
		jTextField_timeZone.setFont(f);
		jTextField_timeZone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getTimeID();	
			}
		});
		

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1, 3));
		jPanel.add(jLabel_timeZone);
		jPanel.add(jTextField_timeZone);
		jPanel.add(jButton_newClock);

		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.SOUTH);
		this.add(jLabel_clock, BorderLayout.CENTER);
		this.setVisible(true);
		
		Thread t = new Thread(this);
		t.start();

	}
	public void getTimeID() {
		try {
		TimeZone timeZone = TimeZone.getTimeZone(jTextField_timeZone.getText().trim());
		String timeZoneID = timeZone.getID();
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(timeZone);
		String time = dateFormat.format(new Date());
		jLabel_clock.setText(time);
		System.out.println(time);
	} catch (Exception e) {
		System.out.println("Invalid timeZone");
	}
	}
	//Cap nhat thoi gian sau 1 giay:
	@Override
	public void run() {
		while(true) {
			try {
				getTimeID();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new Ex4();
	}
}
