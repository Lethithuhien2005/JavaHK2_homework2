package Exercise_IOStream;

public class Employee extends HR {
	private String department;

	public Employee(String name, int day, int month, int year, double coeffSalary, String department) {
		super(name, day, month, year, coeffSalary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
