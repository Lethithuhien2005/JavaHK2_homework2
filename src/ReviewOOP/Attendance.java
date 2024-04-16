package ReviewOOP;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Attendance extends JFrame {
	private JTable jTable_student;
	private JLabel jLabel_1;
	private JLabel jLabel_2;
	private JLabel jLabel_3;
	private JLabel jLabel_4;
	private JLabel jLabel_5;
	private JLabel jLabel_6;
	private JLabel jLabel_7;
	private JLabel jLabel_8;
	private JComponent jLabel_9;
	private JLabel jLabel_10;
	private JButton jButton_normal;
	private JButton jButton_authorizedAbsence;
	private JButton jButton_absent;
	private Statement stm;
	private Connection conn;
	private DefaultTableModel model;
	private Vector vTitle;
	private Vector vData;
	public Attendance() {
		this.setTitle("Attendance");
		this.setSize(700, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial", Font.BOLD, 15);
		
		vData =  null; vTitle = null;

			try {
			ResultSet rs = new DBConnection().queryDB("select * from student");
			ResultSetMetaData rsm = rs.getMetaData();
			int colNum = rsm.getColumnCount();
			vTitle = new Vector(colNum);
			for (int i=1; i<= colNum; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}
			vData = new Vector(50,50);
			while (rs.next()) {
				Vector row = new Vector(colNum);
				for (int i=1; i<=colNum; i++) {
					row.add(rs.getString(i));
				}
				vData.add(row);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		model = new DefaultTableModel(vData, vTitle);
		JTable jTable_student = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(jTable_student, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jButton_normal = new JButton("Normal");
		jButton_normal.setFont(font);
	
		jButton_authorizedAbsence = new JButton("Authorized absence");
		jButton_authorizedAbsence.setFont(font);
		jButton_authorizedAbsence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				authorizedAbsence(new Student());
				
			}
		});
		jButton_absent = new JButton("Absent");
		jButton_absent.setFont(font);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());
		jPanel_button.add(jButton_normal);
		jPanel_button.add(jButton_authorizedAbsence);
		jPanel_button.add(jButton_absent);
		
		this.setLayout(new BorderLayout());
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel_button, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public void authorizedAbsence(Student s) {
		try {
			int selectedStudent = jTable_student.getSelectedRow();
			double num =s.authorized();
			Vector pt = (Vector) this.vData.elementAt(selectedStudent);
			String sql = "UPDATE student SET numAbsent = num WHERE = ID=?\"";
			PreparedStatement pr = new DBConnection().conn.prepareStatement(sql);
			pr.executeUpdate(sql);
			model.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void absent(Student s) {
		try {
			int selectedStudent = jTable_student.getSelectedRow();
			double num =s.absent();
			Vector pt = (Vector) this.vData.elementAt(selectedStudent);
			String sql = "UPDATE student SET numAbsent = num WHERE = ID=?\"";
			PreparedStatement pr = new DBConnection().conn.prepareStatement(sql);
			pr.executeUpdate(sql);
			model.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Attendance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
