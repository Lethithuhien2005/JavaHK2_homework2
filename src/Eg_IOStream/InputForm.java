package Eg_IOStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;

public class InputForm extends Frame implements ActionListener {
	private Label namelb;
	private TextField name;
	private Label idlb;
	private TextField id;
	private Label averlb;
	private TextField aver;
	Button save, newInput, cancel;
	StudentManagement main_frame;
	
	public InputForm(StudentManagement a, String s) {
		super(s);
		main_frame = a;
		
		this.setLayout(new BorderLayout());
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(3,2));
		
		namelb = new Label("Name");
		name = new TextField(20);
		p1.add(namelb);
		p1.add(name);
		
		idlb = new Label("Id");
		id = new TextField(20);
		p1.add(idlb);
		p1.add(id);
		
		averlb = new Label("Average");
		aver = new TextField(20);
		p1.add(averlb);
		p1.add(aver);
		
		this.add(p1, "North");
		
		Panel p2 = new Panel();
		save = new Button("Save");
		newInput = new Button("New");
		cancel = new Button("Cancel");
		save.addActionListener(this);
		newInput.addActionListener(this);
		cancel.addActionListener(this);
		p2.add(save);
		p2.add(newInput);
		p2.add(cancel);

		this.add(p2, "South");
		this.setSize(300, 300);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Save"))
		{
			main_frame.updateList(name.getText(), id.getText(), Float.parseFloat(aver.getText()));
		}
		if (e.getActionCommand().equals("New")) {
			reset();
		}
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose(); // = System.exit(0);
		}
	}
	
	public void reset() {
		name.setText("");
		id.setText("");
		aver.setText("0");
	}
}
