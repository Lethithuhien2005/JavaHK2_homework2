package Exercise_MutiThreading;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3 extends JFrame implements Runnable {
	private JButton jButton_start;
	private JButton jButton_stop;
	private int numBalls[] = new int[10];
	private String status = "Moving";
	private Balls[] ball;

	public Ex3() {
		this.setTitle("Moving of balls");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f = new Font("Arial", Font.BOLD, 15);
		
		jButton_start = new JButton("Start");
		jButton_start.setFont(f);
		jButton_stop = new JButton("Stop");
		jButton_stop.setFont(f);
		
		this.add(jButton_start);
		this.add(jButton_stop);
		this.setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public synchronized void run() {
		
	}
//	public void paint()
	}

