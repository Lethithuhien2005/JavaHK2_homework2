package Exercise_IOStream;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Eg_IOStream.Student;

public class Exercise2 extends JFrame {
	private JLabel jLabel_name;
	private JTextField jTextField_name;
	private JLabel jLabel_birth;
	private JTextField jTextField_birth;
	private JLabel jLabel_email;
	private JTextField jTextField_email;
	private JLabel jLabel_phone;
	private JTextField jTextField_phone;
	private JButton jButton_save;
	private JButton jButton_cancel;
	File file;
	BufferedReader br;

	public Exercise2() {
		this.setSize(300,300);
		this.setTitle("Information");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font  font = new Font("Arial", Font.BOLD, 15);
		
		JPanel jPanel_input = new JPanel();
		jPanel_input.setLayout(new GridLayout(4,2,10,10));
		
		jLabel_name = new JLabel("Name");
		jLabel_name.setFont(font);
		jTextField_name = new JTextField(20);
		jTextField_name.setFont(font);
		jLabel_birth = new JLabel("Date of birth");
		jLabel_birth.setFont(font);
		jTextField_birth = new JTextField();
		jTextField_birth.setFont(font);
		jLabel_email = new JLabel("Email");
		jLabel_email.setFont(font);;
		jTextField_email = new JTextField();
		jTextField_email.setFont(font);
		jLabel_phone = new JLabel("Phone number");
		jLabel_phone.setFont(font);
		jTextField_phone = new JTextField(10);
		jTextField_phone.setFont(font);
		
		jPanel_input.add(jLabel_name);
		jPanel_input.add(jTextField_name);
		jPanel_input.add(jLabel_birth);
		jPanel_input.add(jTextField_birth);
		jPanel_input.add(jLabel_email);
		jPanel_input.add(jTextField_email);
		jPanel_input.add(jLabel_phone);
		jPanel_input.add(jTextField_phone);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());
		
		jButton_save = new JButton("Save");
		jButton_save.setFont(font);
		jButton_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Save")) {
					saveInformation();
				}
				
			}
		});
		jButton_cancel = new JButton("Cancel");
		jButton_cancel.setFont(font);
		jButton_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Cancel")) {
					System.exit(0);
				}
				
			}
		});
		
		jPanel_button.add(jButton_save);
		jPanel_button.add(jButton_cancel);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_input, BorderLayout.CENTER);
		this.add(jPanel_button, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		file = new File("D:\\Users/DIEN MAY XANH/eclipse-workspace/homework2/src/Exercise_IOStream/InformationFile.txt");
		if (file.exists()) {
			loadData();
		}
	}
	
	public void saveInformation() {
		try {
			file = new File("D:\\Users/DIEN MAY XANH/eclipse-workspace/homework2/src/Exercise_IOStream/InformationFile.txt");
			OutputStream os = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
			writer.write(jTextField_name.getText() + "\n");
			writer.write(jTextField_birth.getText() + "\n");
			writer.write(jTextField_email.getText() + "\n");
			writer.write(jTextField_phone.getText() + "\n");
			writer.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadData() {
			FileReader f;
			try {
				f = new FileReader(file);
				br = new BufferedReader(f);
				jTextField_name.setText(br.readLine());
				jTextField_birth.setText(br.readLine());
				jTextField_email.setText(br.readLine());
				jTextField_phone.setText(br.readLine());
				f.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();	
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Exercise2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
