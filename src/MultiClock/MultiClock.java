package MultiClock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiClock extends JFrame implements Runnable {

	public JButton jButton_newClock;
	public JLabel jLabel_timeZone;
	public JTextField jTextField_timeZone;
	public JLabel jLabel_clock;
	private Calendar now;
	private SimpleDateFormat sdf;
	private ZoneOffset zoneOffset;

	public MultiClock() {
		this.setTitle("Time zone");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel jPanel_infor = new JPanel();

		jLabel_clock = new JLabel();
		jLabel_clock.setFont(new Font(jLabel_clock.getFont().getName(), Font.PLAIN, 40));
		jLabel_clock.setForeground(Color.red);
		jButton_newClock = new JButton("New Clock");
		jButton_newClock.setFont(font);
		jButton_newClock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("New Clock")) {
					Thread t = new Thread(new MultiClock());
					t.start();
				}
			}
		});
		jLabel_timeZone = new JLabel("Time zone");
		jLabel_timeZone.setFont(font);
		jTextField_timeZone = new JTextField();
		jTextField_timeZone.setFont(font);
		jTextField_timeZone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZone();
			}
		});

		jPanel_infor.setLayout(new GridLayout(1, 3));
		jPanel_infor.add(jLabel_timeZone);
		jPanel_infor.add(jTextField_timeZone);
		jPanel_infor.add(jButton_newClock);

		this.setLayout(new BorderLayout());
		this.add(jPanel_infor, BorderLayout.SOUTH);
		this.add(jLabel_clock, BorderLayout.CENTER);
		this.setSize(300, 150);
		this.setVisible(true);
		Thread t = new Thread(this);
		t.start();
	}

	public void timeZone() {
		try {
			// Chuyen doi kieu du lieu cua jTextField sang kieu int:
			int input = Integer.parseInt(jTextField_timeZone.getText().trim());
			// Lay do lech thoi gian cua mui gio
			zoneOffset = ZoneOffset.ofHours(input);
			// Lay thoi gian hien tai cua mui gio:
			LocalTime now = LocalTime.now(ZoneId.ofOffset("GMT", zoneOffset));
			// Dinh dang thoi gian:
			DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
			// Hien thi thoi gian cua mui gio:
			String currentTime = now.format(formatTime);
			jLabel_clock.setText(currentTime);
		} catch (NumberFormatException | DateTimeException ex) {
			System.out.println("Invalid timeZone");
		}
	}

	// Cap nhat lai thoi gian sau 1 giay:
	@Override
	public void run() {
		while (true) {
			try {
				timeZone();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MultiClock();
	}
}