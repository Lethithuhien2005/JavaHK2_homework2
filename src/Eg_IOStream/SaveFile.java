package Eg_IOStream;

import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveFile extends JFrame implements ActionListener {
	JTextArea ta = new JTextArea();
	JButton saveAs = new JButton("Save as..");
	JFileChooser chooser;
	FileWriter f;

	public SaveFile() {
		Container cont = this.getContentPane();
		saveAs.addActionListener(this);
		cont.add(ta);
		cont.add(saveAs, "South");
		this.setSize(400, 400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Save as..");
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().getAbsolutePath();
			saveFile(filename);
		}
	}
	public void saveFile(String filename) {
		try {
			String content = ta.getText();
			f = new FileWriter(filename);
			f.write(content);
			f.flush();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SaveFile();
	}
}
