package Eg_IOStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;

public class StudentManagement extends Frame implements ActionListener {
	
	private MenuBar bar;
	private Menu action;
	private MenuItem input, search, sort_view, exit;
	
	FileWriter f ;
	PrintWriter pr;
	
	Vector list = new Vector();
	
	public StudentManagement(String s) {
		super(s);
		loadData();
		
		bar = new MenuBar();
		setMenuBar(bar);
		action = new Menu("Action");
		bar.add(action);
		action.addActionListener(this);
		
		input = new MenuItem("Input");
		action.add(input);
		input.addActionListener(this);	
		
		action.addSeparator();
		sort_view = new MenuItem("Sort and View");
		action.add(sort_view);
		sort_view.addActionListener(this);
		
		action.addSeparator();
		search = new MenuItem("Search");
		action.add(search);
		search.addActionListener(this);
		
		action.addSeparator();
		exit = new MenuItem("Exit");
		action.add(exit);
		exit.addActionListener(this);
		
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit")) {
			saveFile();
			System.exit(0);
		}
		if (e.getActionCommand().equals("Input")) {
			InputForm f = new InputForm(this, "Input information");
		}
		if (e.getActionCommand().equals("Sort and View")) {
			sort();
		}
		if (e.getActionCommand().equals("Search")) {
			new SearchForm("Search", list);
		}
	}
	
	public void updateList(String n, String i, float a) {
		Student st = new Student(n,i,a);
		list.add(st);
	}
	
	public void saveFile() {
		try {
			f = new FileWriter("D:\\data.txt", false);
			pr = new PrintWriter(f);
			Enumeration vEnum = list.elements();
			while (vEnum.hasMoreElements()) {
				Student st = (Student)vEnum.nextElement();
				String toString = st.getName() + "&" + st.getId() + "&" + st.getAver();
				pr.println(toString);
				pr.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadData() {
		try {
			FileReader fr = new FileReader("D:\\data.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s=br.readLine()) != null) {
				String[] data = s.split("&");
				Student st = new Student(data[0], data[1], Float.parseFloat(data[2]));
				list.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sort() {
		Student[] sts = new Student[list.size()];
		int index=0;
		Enumeration vEnum = list.elements();
		while (vEnum.hasMoreElements()) {
			sts[index] = (Student)vEnum.nextElement();
			index++;
		}
		Arrays.sort(sts);
		TextArea ta = new TextArea("Name \t id \t aver\n");
		for (index=0; index<sts.length; index++) {
			ta.append(sts[index].getName() + "\t" +sts[index].getId() + "\t" + sts[index].getAver() + "\n");
		}
		this.add(ta);
		this.validate(); // Cap nhat lai giao dien
	}
	
	public static void main(String[] args) {
		new StudentManagement("Student Management");
	}
}

