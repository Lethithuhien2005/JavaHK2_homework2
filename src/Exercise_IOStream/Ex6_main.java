package Exercise_IOStream;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class Ex6_main extends JFrame implements ActionListener {
	private JMenu jMenu_Input;
	private JMenuItem jMenuItem_salary;
	private JMenuItem jMenuItem_birth;
	private JMenuItem jMenuItem_department;
	private JMenuItem jMenuItem_sortSalary;
	private JMenuItem jMenuItem_search;
	private JMenuItem jMenuItem_Director;
	private JMenuItem jMenuItem_Employee;
	private JMenuItem jMenuItem_Manager;
	public Vector listHR = new Vector();
	private JMenuItem jMenuItem_Save;

	public Ex6_main(String s) {
		super(s);
		this.setSize(300, 300);
		this.setTitle("Managing human resources");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar jMenuBar = new JMenuBar();
		Font font = new Font("Arial", Font.BOLD, 15);
		
		jMenu_Input = new JMenu("Input");
		jMenu_Input.setFont(font);
		
		jMenuItem_Director = new JMenuItem("Director");
		jMenuItem_Director.setFont(font);
		jMenuItem_Director.addActionListener(this);
		jMenuItem_Manager = new JMenuItem("Manager");
		jMenuItem_Manager.setFont(font);
		jMenuItem_Manager.addActionListener(this);
		jMenuItem_Employee = new JMenuItem("Employee");
		jMenuItem_Employee.setFont(font);
		jMenuItem_Employee.addActionListener(this);
		jMenuItem_Save= new JMenuItem("Save");
		jMenuItem_Save.setFont(font);
		jMenuItem_Save.addActionListener(this);
		
		jMenu_Input.add(jMenuItem_Director);
		jMenu_Input.add(jMenuItem_Manager);
		jMenu_Input.add(jMenuItem_Employee);
		jMenu_Input.add(jMenuItem_Save);
		
		JMenu jMenu_Function = new JMenu("Function");
		jMenu_Function.setFont(font);
		
		jMenuItem_salary = new JMenuItem("Highest salary");
		jMenuItem_salary.setFont(font);
		jMenuItem_birth = new JMenuItem("Birth in December");
		jMenuItem_birth.setFont(font);
		jMenuItem_department = new JMenuItem("Department");
		jMenuItem_department.setFont(font);
		jMenuItem_sortSalary = new JMenuItem("Sort salary");
		jMenuItem_sortSalary.setFont(font);
		jMenuItem_search = new JMenuItem("Search");
		jMenuItem_search.setFont(font);
		
		jMenu_Function.add(jMenuItem_salary);
		jMenu_Function.add(jMenuItem_birth);
		jMenu_Function.add(jMenuItem_department);
		jMenu_Function.add(jMenuItem_sortSalary);
		jMenu_Function.add(jMenuItem_search);

		jMenuBar.add(jMenu_Input);
		jMenuBar.add(jMenu_Function);
		
		this.setJMenuBar(jMenuBar);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Director")) {
			new InputFormDirect(this, "Input director's information");
		}
		if (e.getActionCommand().equals("Manager")) {
			new InputFormManager(this, "Input manager's information");
		}
		if (e.getActionCommand().equals("Employee")) {
			new InputFormEmployee(this, "Input employee's information");
		}
		if (e.getActionCommand().equals("Save")) {
			saveFile();
		}
	}
	
	public void updateListD(String n, int d, int m, int y, double coeffSal, double coeffPos) {
		Director dr = new Director(n, d, m, y, coeffSal, coeffPos);
		listHR.add(dr);
	}
	public void updateListM(String n, int d, int m, int y, double coeffSal, int numEmpl) {
		Manager mg = new Manager(n, d, m, y, coeffSal, numEmpl);
		listHR.add(mg);
	}
	public void updateListE(String n, int d, int m, int y, double coeffSal, String dep) {
		Employee ep = new Employee(n, d, m, y, coeffSal, dep);
		listHR.add(ep);
	}
	
	public void saveFile() {
		try {
			FileWriter fw = new FileWriter("D:\\Users/DIEN MAY XANH/eclipse-workspace/homework2/HR.txt", false);
			PrintWriter pr = new PrintWriter(fw);
			Enumeration vEnum = listHR.elements();
			while (vEnum.hasMoreElements()) {
				Director drt = (Director)vEnum.nextElement();
				String toString = "Name: " + drt.getName() + "\n" + "Date of birth: " + drt.getDay() + "-" + drt.getMonth() + "-" + drt.getYear() + "\n" + "Coefficient salary: " + drt.getCoeffSalary() + "\n" +"Coefficient position: " + drt.getCoeffPos();
				pr.write(toString);
				Manager mng = (Manager)vEnum.nextElement();
				String s = "Name: " + mng.getName() + "\n" + "Date of birth: " + mng.getDay() + "-" + mng.getMonth() + "-" + mng.getYear() + "\n" + "Coefficient salary: " + mng.getCoeffSalary() + "\n" +"Number of employees: " + mng.getNumEmployee();
				pr.println(s);
				Employee empl = (Employee)vEnum.nextElement();
				String str = "Name: " + empl.getName() + "\n" + "Date of birth: " + empl.getDay() + "-" + empl.getMonth() + "-" + empl.getYear() + "\n" + "Coefficient salary: " + empl.getCoeffSalary() + "\n" +"Department's name: " + empl.getDepartment();
				pr.write(str);
				pr.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Ex6_main("Managing human resources");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
