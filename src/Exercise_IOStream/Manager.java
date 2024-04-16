package Exercise_IOStream;

public class Manager extends HR {
	private int numEmployee;

	public Manager(String name, int day, int month, int year, double coeffSalary, int numEmployee) {
		super(name, day, month, year, coeffSalary);
		this.numEmployee = numEmployee;
	}

	public int getNumEmployee() {
		return numEmployee;
	}

	public void setNumEmployee(int numEmployee) {
		this.numEmployee = numEmployee;
	}

}
