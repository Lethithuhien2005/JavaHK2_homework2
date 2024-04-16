package Eg_IOStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.*;

public class SearchForm extends Frame implements ActionListener {
	private Label namelb;
	private TextField name;
	private TextArea ta;
	private Button search, cancel;
	private Vector list;
	
	public SearchForm(String s, Vector v) {
		super(s);
		list = v;
		
		setLayout(new BorderLayout());
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3,2));
		namelb = new Label("Name");
		name = new TextField(20);
		p1.add(namelb);
		p1.add(name);
		
		this.add(p1, "North");
		
		ta = new TextArea("Name \t Id \t Aver \n");
		this.add(ta, "Center");
		
		Panel p2 = new Panel();
		search = new Button("Search");
		cancel = new Button("Cancel");
		search.addActionListener(this);
		cancel.addActionListener(this);
		p2.add(search);
		p2.add(cancel);
		
		this.add(p2, "South");
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Search")) {
			search(name.getText());
		}
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}
	}
	
	public void search(String s) {
		Enumeration vEnum = list.elements();
		while (vEnum.hasMoreElements()) {
			Student st = (Student)vEnum.nextElement();
			if (st.getName().indexOf(s) != -1) {
				ta.append(st.getName() + "\t" + st.getId() + "\t" + st.getAver() + "\n");
			}
		}
		this.validate();
	}
}
