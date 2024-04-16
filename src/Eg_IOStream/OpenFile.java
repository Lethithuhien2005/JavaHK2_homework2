package Eg_IOStream;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OpenFile extends JFrame implements ActionListener {
	JTextArea ta = new JTextArea();
	JButton open = new JButton("Open..");
	JFileChooser chooser;
	FileReader fr;
	BufferedReader br;
	private String filename;

	public OpenFile() {
		Container cont = this.getContentPane();
		open.addActionListener(this);
		cont.add(ta);
		cont.add(open, "South");
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Open file");
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			filename = chooser.getSelectedFile().getAbsolutePath();
			readFile(filename);
		}
	}

	public void readFile(String filename) {
		try {
			ta.setText("");
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new OpenFile();
	}
}
