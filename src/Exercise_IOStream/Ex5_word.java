package Exercise_IOStream;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Ex5_word extends JFrame implements ActionListener {
	private JMenuItem jMenuItem_new;
	private JMenuItem jMenuItem_open;
	private JMenuItem jMenuItem_save;
	private JMenuItem jMenuItem_saveAs;
	private JMenuItem jMenuItem_copy;
	private JMenuItem jMenuItem_cut;
	private JMenuItem jMenuItem_paste;
	private JTextArea jTextArea;
	private JFileChooser fileChooser;
	private String fileName;
	private JScrollPane jScrollPane;
	private Reader fr;
	private BufferedReader br;

	public Ex5_word() {
		this.setTitle("Soan thao van ban");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f = new Font("Arial", Font.BOLD, 15);
		
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenu_File = new JMenu("File");
		jMenu_File.setFont(f);
		jMenuItem_new = new JMenuItem("New");
		jMenuItem_new.setFont(f);
		jMenuItem_new.addActionListener(this);
		jMenuItem_open = new JMenuItem("Open");
		jMenuItem_open.setFont(f);
		jMenuItem_open.addActionListener(this);
		jMenuItem_save = new JMenuItem("Save");
		jMenuItem_save.setFont(f);
		jMenuItem_save.addActionListener(this);
		jMenuItem_saveAs = new JMenuItem("Save as");
		jMenuItem_saveAs.setFont(f);
		jMenuItem_saveAs.addActionListener(this);
		
		jMenu_File.add(jMenuItem_new);
		jMenu_File.add(jMenuItem_open);
		jMenu_File.add(jMenuItem_save);
		jMenu_File.add(jMenuItem_saveAs);

		JMenu jMenu_Edit = new JMenu("Edit");
		jMenu_Edit.setFont(f);
		jMenuItem_copy = new JMenuItem("Copy");
		jMenuItem_copy.setFont(f);
		jMenuItem_copy.addActionListener(this);
		jMenuItem_cut = new JMenuItem("Cut");
		jMenuItem_cut.setFont(f);
		jMenuItem_cut.addActionListener(this);
		jMenuItem_paste = new JMenuItem("Paste");
		jMenuItem_paste.setFont(f);
		jMenuItem_paste.addActionListener(this);

		jMenu_Edit.add(jMenuItem_copy);
		jMenu_Edit.add(jMenuItem_cut);
		jMenu_Edit.add(jMenuItem_paste);
		
		jMenuBar.add(jMenu_File);
		jMenuBar.add(jMenu_Edit);
		
		jTextArea = new JTextArea(100,50);
		jTextArea.setFont(f);
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		this.setJMenuBar(jMenuBar);
		this.add(jScrollPane);
		this.setVisible(true);
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			jTextArea.setText("");
		}
		if (e.getActionCommand().equals("Open")) {
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setDialogTitle("Open File");
			if ((fileChooser.showOpenDialog(this)) == JFileChooser.APPROVE_OPTION) {
				fileName = fileChooser.getSelectedFile().getAbsolutePath();
				readFile(fileName);
			}
		}
		if (e.getActionCommand().equals("Save")) {
			saveFile(fileName);
		}
		if (e.getActionCommand().equals("Save as")) {
			JFileChooser fChooser = new JFileChooser();
			fChooser.setCurrentDirectory(new java.io.File("."));
			fChooser.setDialogTitle("Save as file");
			if (fChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				String fName = fChooser.getSelectedFile().getAbsolutePath();
				saveAs(fName);
			}
		}
		if (e.getActionCommand().equals("Copy")) {
			jTextArea.copy();
		}
		if (e.getActionCommand().equals("Cut")) {
			jTextArea.cut();
		}
		if (e.getActionCommand().equals("Paste")) {
			jTextArea.paste();
		}
	}
	public void readFile(String path) {
		try {
			jTextArea.setText("");
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String s;
			while ((s=br.readLine()) != null) {
				jTextArea.append(s + "\n");
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveFile(String path) {
		try {
			String content = jTextArea.getText();
			FileWriter fWr = new FileWriter(fileName);
			fWr.write(content);
			fWr.flush();
			fWr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveAs(String fName) {
		try {
			String content = jTextArea.getText();
			FileWriter fileWriter = new FileWriter(fName);
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Ex5_word();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
