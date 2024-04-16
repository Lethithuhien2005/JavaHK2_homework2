package Exercise_IOStream;

public class Director extends HR {

	private double coeffPos;

	public Director(String name, int day, int month, int year, double coeffSalary, double coeffPos) {
		super(name, day, month, year, coeffSalary);
		this.coeffPos = coeffPos;
	}

	public double getCoeffPos() {
		return coeffPos;
	}

	public void setCoeffPos(double coeffPos) {
		this.coeffPos = coeffPos;
	}

}
