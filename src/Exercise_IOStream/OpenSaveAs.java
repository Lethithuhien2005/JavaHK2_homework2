package Exercise_IOStream;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OpenSaveAs extends JFrame implements ActionListener {
	private JTextArea jTextArea;
	private JButton jButton_saveAs;
	private JFileChooser fileChooser;
	private FileReader newFile;
	private BufferedReader br;
	private JButton jButton_Open;
	public OpenSaveAs(){
		this.setTitle("Display and Save As");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font f = new Font("Times New Roman", Font.BOLD, 16);
		jTextArea = new JTextArea(100, 100);
		jTextArea.setFont(f);
		jButton_saveAs = new JButton("Save as");
		jButton_saveAs.setFont(f);
		jButton_saveAs.addActionListener(this);
		jButton_Open = new JButton("Open");
		jButton_Open.setFont(f);
		jButton_Open.addActionListener(this);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1,2));
		jPanel.add(jButton_Open);
		jPanel.add(jButton_saveAs);
		
		this.add(jTextArea);
		this.add(jPanel, "South");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Open")) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setDialogTitle("Open file");
			if (fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
				String file = fileChooser.getSelectedFile().getAbsolutePath();
				readFile(file);
			}
		}
		if (e.getActionCommand().equals("Save as")) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setDialogTitle("Save file");
			if (fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
				String f = fileChooser.getSelectedFile().getAbsolutePath();
				saveFile(f);
			}
		}
	}
	public void readFile(String fileName) {
		try {
			jTextArea.setText("");
			newFile = new FileReader(fileName);
			br = new BufferedReader(newFile);
			String s;
			while ((s = br.readLine()) != null) {
				jTextArea.append(s + "\n");
			}
			newFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(String fileName) {
		try {
			String content = jTextArea.getText();
			FileWriter fW = new FileWriter(fileName);
			fW.write(content);
			fW.flush();
			fW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new OpenSaveAs();
	}
}
