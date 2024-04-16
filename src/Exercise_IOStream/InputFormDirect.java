package Exercise_IOStream;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class InputFormDirect extends JFrame implements ActionListener{
	Ex6_main mainFrame;
	private JTextField jTextField_name;
	private JTextField jTextField_day;
	private JTextField jTextField_month;
	private JTextField jTextField_year;
	private JTextField jTextField_coeffPos;
//	private Vector listD = new Vector();
	private JTextField jTextField_coeffSalary;
	public InputFormDirect(Ex6_main a, String s) {
		super(s);
		mainFrame = a;
		
		this.setSize(400, 300);
		this.setTitle("Input director's information");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f = new Font("Arial", Font.BOLD, 15);
		
		JLabel jLabel_name = new JLabel("Name");
		jLabel_name.setFont(f);
		jTextField_name = new JTextField(20);
		jTextField_name.setFont(f);
		JLabel jLabel_day = new JLabel("Day");
		jLabel_day.setFont(f);
		jTextField_day = new JTextField(20);
		jTextField_day.setFont(f);
		JLabel jLabel_month = new JLabel("Month");
		jLabel_month.setFont(f);
		jTextField_month = new JTextField(20);
		jTextField_month.setFont(f);
		JLabel jLabel_year = new JLabel("Year");
		jLabel_year.setFont(f);
		jTextField_year = new JTextField(20);
		jTextField_year.setFont(f);
		JLabel jLabel_coeffSalary = new JLabel("Coefficient salary");
		jLabel_coeffSalary.setFont(f);
		jTextField_coeffSalary = new JTextField(20);
		jTextField_coeffSalary.setFont(f);
		JLabel jLabel_coeffPos = new JLabel("Coefficent position");
		jLabel_coeffPos.setFont(f);
		jTextField_coeffPos = new JTextField(20);
		jTextField_coeffPos.setFont(f);
		
		JPanel jPanel_input = new JPanel();
		jPanel_input.setLayout(new GridLayout(6,2,2,2));
		jPanel_input.add(jLabel_name);
		jPanel_input.add(jTextField_name);
		jPanel_input.add(jLabel_day);
		jPanel_input.add(jTextField_day);
		jPanel_input.add(jLabel_month);
		jPanel_input.add(jTextField_month);
		jPanel_input.add(jLabel_year);
		jPanel_input.add(jTextField_year);
		jPanel_input.add(jLabel_coeffSalary);
		jPanel_input.add(jTextField_coeffSalary);
		jPanel_input.add(jLabel_coeffPos);
		jPanel_input.add(jTextField_coeffPos);

		JButton jButton_new = new JButton("New");
		jButton_new.setFont(f);
		jButton_new.addActionListener(this);
		JButton jButton_save = new JButton("Save");
		jButton_save.setFont(f);
		jButton_save.addActionListener(this);
		JButton jButton_back = new JButton("Back");
		jButton_back.setFont(f);
		jButton_back.addActionListener(this);
		
		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());
		jPanel_button.add(jButton_new);
		jPanel_button.add(jButton_save);
		jPanel_button.add(jButton_back);

		this.setLayout(new BorderLayout() );
		this.add(jPanel_input, BorderLayout.CENTER);
		this.add(jPanel_button, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public void reset() {
		jTextField_name.setText("");
		jTextField_day.setText("");
		jTextField_month.setText("");
		jTextField_year.setText("");
		jTextField_coeffSalary.setText("");
		jTextField_coeffPos.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			reset();
		}
		if (e.getActionCommand().equals("Save")) {
			mainFrame.updateListD(jTextField_name.getText(), Integer.parseInt(jTextField_day.getText()), Integer.parseInt(jTextField_month.getText()), Integer.parseInt(jTextField_year.getText()), Double.parseDouble(jTextField_coeffSalary.getText()), Double.parseDouble(jTextField_coeffPos.getText()));
		}
		if (e.getActionCommand().equals("Back")) {
			this.dispose();
		}
	}
	
//	public void saveFile() {
//		try {
//			FileWriter fw = new FileWriter("D:\\Users/DIEN MAY XANH/eclipse-workspace/homework2/HR.txt", false);
//			PrintWriter pw = new PrintWriter(fw);
//			Enumeration vEnum = listD.elements();
//			while(vEnum.hasMoreElements()) {
//				Director drt = (Director)vEnum.nextElement();
//				String toString = "Name: " + drt.getName() + "\n" + "Date of birth: " + drt.getDay() + "-" + drt.getMonth() + "-" + drt.getYear() + "\n" + "Coefficient salary: " + drt.getCoeffSalary() + "\n" +"Coefficient position: " + drt.getCoeffPos();
//				pw.write(toString);
//				pw.flush();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
